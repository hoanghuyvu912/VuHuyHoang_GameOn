package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.ReceiptDetailsRepository;
import com.nonIt.GameOn.repository.ReceiptRepository;
import com.nonIt.GameOn.service.ReceiptDetailsService;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.mapper.ReceiptDetailsMapper;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
}
