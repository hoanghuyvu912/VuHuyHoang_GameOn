package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.service.dto.ReceiptDto;
import com.nonIt.GameOn.service.restDto.ReceiptRestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceiptMapper extends EntityMapper<ReceiptRestDto, Receipt, ReceiptDto>{
//    ReceiptDto toDto(Receipt receipt);
//
//    List<ReceiptDto> toDtos(List<Receipt> receipts);
//
//    ReceiptRestDto toRestDto(Receipt receipt);
//
//    List<ReceiptRestDto> toRestDtos(List<Receipt> receipts);
}
