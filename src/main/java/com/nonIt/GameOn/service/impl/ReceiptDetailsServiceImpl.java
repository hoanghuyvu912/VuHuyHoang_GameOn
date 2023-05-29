package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.ReceiptDetailsRepository;
import com.nonIt.GameOn.repository.ReceiptRepository;
import com.nonIt.GameOn.service.ReceiptDetailsService;
import com.nonIt.GameOn.service.customDto.RevenuePerDateDto;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.mapper.ReceiptDetailsMapper;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReceiptDetailsServiceImpl implements ReceiptDetailsService {
    private final ReceiptDetailsRepository receiptDetailsRepository;
    private final ReceiptRepository receiptRepository;
    private final GameRepository gameRepository;
    private final ReceiptDetailsMapper receiptDetailsMapper;

    @Override
    public List<ReceiptDetailsRestDto> getAll() {
        return receiptDetailsRepository.findAll().stream().map(receiptDetailsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReceiptDetailsRestDto findById(Integer receiptDetailsId) {
        return receiptDetailsRepository.findById(receiptDetailsId).map(receiptDetailsMapper::toDto).orElseThrow(GameOnException::ReceiptDetailsNotFound);
    }

    @Override
    public ReceiptDetailsRestDto createReceiptDetails(ReceiptDetailsDto receiptDetailsDto) {
        Receipt receipt = receiptRepository.findById(receiptDetailsDto.getReceiptId()).orElseThrow(GameOnException::ReceiptNotFound);
        Game game = gameRepository.findById(receiptDetailsDto.getGameId()).orElseThrow(GameOnException::GameNotFound);
        ReceiptDetails receiptDetails = ReceiptDetails.builder()
                .receipt(receipt)
                .game(game)
                .build();
        receiptDetails = receiptDetailsRepository.save(receiptDetails);

        return receiptDetailsMapper.toDto(receiptDetails);
    }

    @Override
    public ReceiptDetailsRestDto updateReceiptDetails(Integer receiptDetailsId, ReceiptDetailsDto receiptDetailsDto) {
        ReceiptDetails receiptDetails = receiptDetailsRepository.findById(receiptDetailsId).orElseThrow(GameOnException::ReceiptDetailsNotFound);
        Receipt receipt = receiptRepository.findById(receiptDetailsDto.getReceiptId()).orElseThrow(GameOnException::ReceiptNotFound);
        Game game = gameRepository.findById(receiptDetailsDto.getGameId()).orElseThrow(GameOnException::GameNotFound);

        if (receipt.getReceiptDate().isBefore(game.getReleasedDate())) {
            throw GameOnException.badRequest("InvalidReceiptDate", "The receipt date cannot be before a game's released date. Please choose a different game, or a different receipt.");
        }
        receiptDetails.setReceipt(receipt);
        receiptDetails.setGame(game);
        receiptDetails = receiptDetailsRepository.save(receiptDetails);
        return receiptDetailsMapper.toDto(receiptDetails);
    }

    @Override
    public void deleteReceiptDetails(Integer receiptDetailsId) {
        receiptDetailsRepository.deleteById(receiptDetailsId);
    }

    @Override
    public List<RevenuePerDateDto> getRevenuePerDateBetweenDates(LocalDate date1, LocalDate date2) {
        return receiptDetailsRepository.getRevenuePerDateBetweenDates(date1, date2);
    }

    private List<Game> getGamesBetweenDates(LocalDate date1, LocalDate date2) {
        return receiptDetailsRepository.findAll().stream()
                .filter(rd -> rd.getReceipt().getReceiptDate().isAfter(date1))
                .filter(rd -> rd.getReceipt().getReceiptDate().isBefore(date2))
                .map(ReceiptDetails::getGame)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Game, Long> getBestSellerGamesBetweenDates(LocalDate date1, LocalDate date2) {
        List<Game> gamesByReceiptDate = getGamesBetweenDates(date1, date2);

        Map<Game, Long> gamesWithCopiesSold = new HashMap<>();
        for (Game game : gamesByReceiptDate) {
            gamesWithCopiesSold.put(game, 0L);
        }

        for (Map.Entry<Game, Long> entry : gamesWithCopiesSold.entrySet()) {
            Game key = entry.getKey();
            Long value = entry.getValue();

            for (Game game : gamesByReceiptDate) {
                if (Objects.equals(game.getId(), key.getId())) {
                    value++;
                    entry.setValue(value);
                }
            }
        }
//        return gamesWithCopiesSold;
        return gamesWithCopiesSold.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<Game, Long>::getValue).reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }


    @Override
    public Map<Game, Long> getWorstSellerGamesBetweenDates(LocalDate date1, LocalDate date2) {
        List<Game> gamesByReceiptDate = getGamesBetweenDates(date1, date2);

        Map<Game, Long> gamesWithCopiesSold = new HashMap<>();
        for (Game game : gamesByReceiptDate) {
            gamesWithCopiesSold.put(game, 0L);
        }

        for (Map.Entry<Game, Long> entry : gamesWithCopiesSold.entrySet()) {
            Game key = entry.getKey();
            Long value = entry.getValue();

            for (Game game : gamesByReceiptDate) {
                if (Objects.equals(game.getId(), key.getId())) {
                    value++;
                    entry.setValue(value);
                }
            }
        }

        return gamesWithCopiesSold.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<Game, Long>::getValue))
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
