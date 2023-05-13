package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.ReceiptRepository;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.service.ReceiptService;
import com.nonIt.GameOn.service.dto.ReceiptDto;
import com.nonIt.GameOn.service.mapper.ReceiptMapper;
import com.nonIt.GameOn.service.restDto.ReceiptRestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final UserRepository userRepository;
    private final ReceiptMapper receiptMapper;

    @Override
    public List<ReceiptRestDto> getAll() {
        return receiptRepository.findAll().stream().map(receiptMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReceiptRestDto findById(Integer receiptId) {
        return receiptRepository.findById(receiptId).map(receiptMapper::toDto).orElseThrow(GameOnException::ReceiptNotFound);
    }

    @Override
    public ReceiptRestDto createReceipt(ReceiptDto receiptDto) {
        User user = userRepository.findById(receiptDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
        if (receiptDto.getReceiptDate().isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReceiptDate", "Receipt date cannot be after current date.");
        }
        Receipt receipt = Receipt.builder()
                .user(user)
                .receiptDate(receiptDto.getReceiptDate())
                .build();

        receipt = receiptRepository.save(receipt);

        return receiptMapper.toDto(receipt);
    }

    @Override
    public ReceiptRestDto updateReceipt(Integer receiptId, ReceiptDto receiptDto) {
        Receipt receipt = receiptRepository.findById(receiptId).orElseThrow(GameOnException::ReceiptNotFound);
        User user = userRepository.findById(receiptDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
        if (receiptDto.getReceiptDate().isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidReceiptDate", "Receipt date cannot be after current date.");
        }
        receiptMapper.updateFromDto(receiptDto, receipt);
        receipt.setUser(user);
        receipt = receiptRepository.save(receipt);

        return receiptMapper.toDto(receipt);
    }

    @Override
    public void deleteReceipt(Integer receiptId) {
        receiptRepository.deleteById(receiptId);
    }
}
