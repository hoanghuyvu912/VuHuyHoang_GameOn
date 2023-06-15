package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.rest.resources_dto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.dto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restDto.ReceiptDetailsRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceiptDetailsMapper extends EntityMapper<ReceiptDetailsRestDto, ReceiptDetails, ReceiptDetailsDto> {
    @Mapping(source = "receipt.id", target = "receiptId")
    @Mapping(source = "id", target = "receiptDetailsId")
    @Mapping(source = "game.id", target = "gameId")
    SimplifiedReceiptDetailsDto toSimplifiedDto(ReceiptDetails receiptDetails);
//    ReceiptDetailsDto toDto(ReceiptDetails receiptDetails);
//
//    List<ReceiptDetailsDto> toDtos(List<ReceiptDetails> receiptDetails);
//
//    ReceiptDetailsRestDto toRestDto(ReceiptDetails receiptDetails);
//
//    List<ReceiptDetailsRestDto> toRestDtos(List<ReceiptDetails> receiptDetails);
}
