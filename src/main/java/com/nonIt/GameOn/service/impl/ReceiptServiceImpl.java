package com.nonIt.GameOn.service.impl;

import com.nonIt.GameOn.entity.Game;
import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.entity.User;
import com.nonIt.GameOn.exception.GameOnException;
import com.nonIt.GameOn.repository.GameRepository;
import com.nonIt.GameOn.repository.ReceiptDetailsRepository;
import com.nonIt.GameOn.repository.ReceiptRepository;
import com.nonIt.GameOn.repository.UserRepository;
import com.nonIt.GameOn.rest.resources_dto.ReceiptCreateDto;
import com.nonIt.GameOn.rest.resources_dto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.ReceiptService;
import com.nonIt.GameOn.service.dto.ReceiptDto;
import com.nonIt.GameOn.service.mapper.ReceiptDetailsMapper;
import com.nonIt.GameOn.service.mapper.ReceiptMapper;
import com.nonIt.GameOn.service.restDto.ReceiptRestDto;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final UserRepository userRepository;
    private final ReceiptMapper receiptMapper;
    private final GameRepository gameRepository;
    private final ReceiptDetailsRepository receiptDetailsRepository;
    private final ReceiptDetailsMapper receiptDetailsMapper;

    @Override
    public List<ReceiptRestDto> getAll() {
        return receiptRepository.findAll().stream().map(receiptMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ReceiptRestDto findById(Integer receiptId) {
        return receiptRepository.findById(receiptId).map(receiptMapper::toDto).orElseThrow(GameOnException::ReceiptNotFound);
    }

    @Override
    public List<ReceiptRestDto> findByReceiptDateAfter(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw GameOnException.badRequest("InvalidDate", "Query date cannot be after current date.");
        }
        return receiptRepository.findByReceiptDateAfter(date).stream().map(receiptMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ReceiptRestDto> findByReceiptDateBefore(LocalDate date) {
        return receiptRepository.findByReceiptDateBefore(date).stream().map(receiptMapper::toDto).collect(Collectors.toList());
    }


//    @Override
//    public ReceiptRestDto createReceipt(ReceiptCreateDto receiptCreateDto) {
//        User user = userRepository.findById(receiptCreateDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
//        List<Integer> gamesIdListOfUser = receiptDetailsRepository.findByReceiptUserId(receiptCreateDto.getUserId()).stream()
//                .map(receiptDetailsMapper::toSimplifiedDto)
//                .map(SimplifiedReceiptDetailsDto::getGameId).collect(Collectors.toList());
//        Receipt receipt = Receipt.builder()
//                .user(user)
//                .build();
//
//        List<ReceiptDetails> receiptDetailsList = new ArrayList<>();
//        Double totalPriceOfCart = 0D;
//
//        for (Integer gameId : receiptCreateDto.getGameIdList()) {
//            for (Integer gameIdOfUser : gamesIdListOfUser) {
//                if (Objects.equals(gameId, gameIdOfUser)) {
//                    throw GameOnException.badRequest("CannotBuyGame", "User has already bought this game!");
//                }
//            }
//            ReceiptDetails receiptDetails = new ReceiptDetails();
//            Game game = gameRepository.findById(gameId).orElseThrow(GameOnException::GameNotFound);
//            totalPriceOfCart += game.getPrice();
//            receiptDetails.setReceipt(receipt);
//            receiptDetails.setGame(game);
//            receiptDetailsList.add(receiptDetails);
//        }
//        if (totalPriceOfCart > user.getBalance()) {
//            throw GameOnException.badRequest("InsufficientBalance", "Insufficient balance. \nYour current balance: $" + user.getBalance() + ". \nTotal price of cart: $" + totalPriceOfCart);
//        }
//
//        user.setBalance(user.getBalance() - totalPriceOfCart);
//
//        receipt.setReceiptDetailsList(receiptDetailsList);
//
//        receipt = receiptRepository.save(receipt);
//
//        return receiptMapper.toDto(receipt);
//    }

    @Override
    public ReceiptRestDto updateReceipt(Integer receiptId, ReceiptDto receiptDto) {
        Receipt receipt = receiptRepository.findById(receiptId).orElseThrow(GameOnException::ReceiptNotFound);
        User user = userRepository.findById(receiptDto.getUserId()).orElseThrow(GameOnException::UserNotFound);
        if (receiptDto.getReceiptDate() != null) {
            if (receiptDto.getReceiptDate().isAfter(LocalDate.now())) {
                throw GameOnException.badRequest("InvalidReceiptDate", "Receipt date cannot be after current date.");
            }
        }
        receiptMapper.mapFromDto(receiptDto, receipt);
        receipt.setUser(user);
        receipt = receiptRepository.save(receipt);

        return receiptMapper.toDto(receipt);
    }

    @Override
    public void deleteReceipt(Integer receiptId) {
        receiptRepository.deleteById(receiptId);
    }

    @Override
    public List<ReceiptRestDto> getByUserId(Integer userId) {
        return receiptRepository.getReceiptByUserId(userId).stream().map(receiptMapper::toDto).collect(Collectors.toList());
    }
}
