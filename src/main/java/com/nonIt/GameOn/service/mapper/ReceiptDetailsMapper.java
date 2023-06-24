package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.ReceiptDetails;
import com.nonIt.GameOn.rest.resourcesdto.SimplifiedReceiptDetailsDto;
import com.nonIt.GameOn.service.createdto.ReceiptDetailsDto;
import com.nonIt.GameOn.service.restdto.ReceiptDetailsRestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReceiptDetailsMapper extends EntityMapper<ReceiptDetailsRestDto, ReceiptDetails, ReceiptDetailsDto> {
    @Mapping(source = "receipt.id", target = "receiptId")
    @Mapping(source = "id", target = "receiptDetailsId")
    @Mapping(source = "gameCode.id ", target = "gameCodeId")
    SimplifiedReceiptDetailsDto toSimplifiedDto(ReceiptDetails receiptDetails);
//    ReceiptDetailsDto toDto(ReceiptDetails receiptDetails);
//
//    List<ReceiptDetailsDto> toDtos(List<ReceiptDetails> receiptDetails);
//
//    ReceiptDetailsRestDto toRestDto(ReceiptDetails receiptDetails);
//
//    List<ReceiptDetailsRestDto> toRestDtos(List<ReceiptDetails> receiptDetails);
}
