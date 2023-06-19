package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.*;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.GameCodeRepository;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.ReceiptDetailsRepository;
import com.nonIt.GameOn.repository.ReceiptRepository;
import com.nonIt.GameOn.rest.resources_dto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.ReceiptDetailsService;
import com.nonIt.GameOn.service.customDto.GameCodeCustomDto;
import com.nonIt.GameOn.service.customDto.GameWithUsedGameCodeListDto;
import com.nonIt.GameOn.service.customDto.RevenuePerDateDto;
import com.nonIt.GameOn.service.dto.GameCodeDto;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.mapper.GameCodeMapper;
import com.nonIt.GameOn.service.mapper.ReceiptDetailsMapper;
import com.nonIt.GameOn.service.restDto.GameCodeRestDto;
import com.nonIt.GameOn.service.restDto.GameRestDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReceiptDetailsServiceImpl implements ReceiptDetailsService {
    private final ReceiptDetailsRepository receiptDetailsRepository;
    private final ReceiptRepository receiptRepository;
    private final GameRepository gameRepository;
    private final ReceiptDetailsMapper receiptDetailsMapper;
    private final GameCodeRepository gameCodeRepository;
    private final GameCodeMapper gameCodeMapper;

    @Override
    public List<ReceiptDetailsRestDto> getAll() {
        return receiptDetailsRepository.findAll().stream().map(receiptDetailsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SimplifiedReceiptDetailsDto> findByReceiptUserId(Integer userId) {
        return receiptDetailsRepository.findByReceiptUserId(userId).stream().map(receiptDetailsMapper::toSimplifiedDto).collect(Collectors.toList());
    }

    @Override
    public ReceiptDetailsRestDto findById(Integer receiptDetailsId) {
        return receiptDetailsRepository.findById(receiptDetailsId).map(receiptDetailsMapper::toDto).orElseThrow(GameOnException::ReceiptDetailsNotFound);
    }

    @Override
    public ReceiptDetailsRestDto createReceiptDetails(ReceiptDetailsDto receiptDetailsDto) {
        Receipt receipt = receiptRepository.findById(receiptDetailsDto.getReceiptId()).orElseThrow(GameOnException::ReceiptNotFound);
        GameCode gameCode = gameCodeRepository.findById(receiptDetailsDto.getGameCodeId()).orElseThrow(GameOnException::GameCodeNotFound);
        ReceiptDetails receiptDetails = ReceiptDetails.builder()
                .receipt(receipt)
                .gameCode(gameCode)
                .build();
        receiptDetails = receiptDetailsRepository.save(receiptDetails);

        return receiptDetailsMapper.toDto(receiptDetails);
    }

    @Override
    public ReceiptDetailsRestDto updateReceiptDetails(Integer receiptDetailsId, ReceiptDetailsDto receiptDetailsDto) {
        ReceiptDetails receiptDetails = receiptDetailsRepository.findById(receiptDetailsId).orElseThrow(GameOnException::ReceiptDetailsNotFound);
        Receipt receipt = receiptRepository.findById(receiptDetailsDto.getReceiptId()).orElseThrow(GameOnException::ReceiptNotFound);
        GameCode gameCode = gameCodeRepository.findById(receiptDetailsDto.getGameCodeId()).orElseThrow(GameOnException::GameCodeNotFound);
//
//        if (receipt.getReceiptDate().isBefore(game.getReleasedDate())) {
//            throw GameOnException.badRequest("InvalidReceiptDate", "The receipt date cannot be before a game's released date. Please choose a different game, or a different receipt.");
//        }
        receiptDetails.setReceipt(receipt);
        receiptDetails.setGameCode(gameCode);
        receiptDetails = receiptDetailsRepository.save(receiptDetails);
        return receiptDetailsMapper.toDto(receiptDetails);
    }

    @Override
    public void deleteReceiptDetails(Integer receiptDetailsId) {
        receiptDetailsRepository.deleteById(receiptDetailsId);
    }

//    @Override
//    public List<RevenuePerDateDto> getRevenuePerDateBetweenDates(LocalDate date1, LocalDate date2) {
//        return receiptDetailsRepository.getRevenuePerDateBetweenDates(date1, date2);
//    }

    @Override
    public List<GameWithUsedGameCodeListDto> getBestSellerGamesBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<GameCode> usedGameCodes = receiptDetailsRepository.findByReceiptReceiptDate(startDate, endDate)
                .stream()
                .map(ReceiptDetails::getGameCode)
                .collect(Collectors.toList());

//        usedGameCodes.forEach(ugc -> System.out.println(ugc.getGameCode()));

        Map<Game, Long> gameWithUsedGameCodeList = usedGameCodes.stream()
                .collect(Collectors.groupingBy(GameCode::getGame, Collectors.counting()));

        gameWithUsedGameCodeList.forEach((key, value) -> System.out.println(key + ":" + value));

        List<GameWithUsedGameCodeListDto> gameWithUsedGameCodeListDtos = gameWithUsedGameCodeList.entrySet().stream()
                .map(entry -> new GameWithUsedGameCodeListDto(entry.getKey(), entry.getValue().intValue()))
                .sorted(Comparator.comparingInt(GameWithUsedGameCodeListDto::getNumberOfUsedGameCode))
                .collect(Collectors.toList());

        return gameWithUsedGameCodeListDtos.subList(0, Math.min(gameWithUsedGameCodeListDtos.size(), 5));
    }

    @Override
    public List<ReceiptDetailsDto> getReceiptDetailListBetweenDates(LocalDate date1, LocalDate date2) {
        List<ReceiptDetailsDto> receiptDetailsDtos = new ArrayList<>();

        receiptDetailsRepository.findByReceiptReceiptDate(date1, date2)
                .forEach(receiptDetails -> {
                    ReceiptDetailsDto receiptDetailsDto = new ReceiptDetailsDto(
                            receiptDetails.getReceipt().getId(),
                            receiptDetails.getGameCode().getId(),
                            receiptDetails.getGamePrice()
                    );
                    receiptDetailsDtos.add(receiptDetailsDto);
                });
        return receiptDetailsDtos;
    }


//        for (Map.Entry<Game, Long> entry : gameWithUsedGameCodeList.entrySet()) {
//            Game key = entry.getKey();
//            Long value = entry.getValue();
//
//            for (Game game : gamesByReceiptDate) {
//                if (Objects.equals(game.getId(), key.getId())) {
//                    value++;
//                    entry.setValue(value);
//                }
//            }
//        }
//        return gamesWithCopiesSold;
//        return gameWithUsedGameCodeList.entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Map.Entry<Game, Long>::getValue).reversed())
//                .limit(5)
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//    }

//    @Override
//    public Map<Game, Long> getWorstSellerGamesBetweenDates(LocalDate date1, LocalDate date2) {
//        List<Game> gamesByReceiptDate = getGamesBetweenDates(date1, date2);
//
//        Map<Game, Long> gamesWithCopiesSold = new HashMap<>();
//        for (Game game : gamesByReceiptDate) {
//            gamesWithCopiesSold.put(game, 0L);
//        }
//
//        for (Map.Entry<Game, Long> entry : gamesWithCopiesSold.entrySet()) {
//            Game key = entry.getKey();
//            Long value = entry.getValue();
//
//            for (Game game : gamesByReceiptDate) {
//                if (Objects.equals(game.getId(), key.getId())) {
//                    value++;
//                    entry.setValue(value);
//                }
//            }
//        }
//
//        return gamesWithCopiesSold.entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Map.Entry<Game, Long>::getValue))
//                .limit(5)
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//    }
}
