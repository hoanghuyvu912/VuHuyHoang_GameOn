package com.nonIt.GameOn.service.mapper;

import com.nonIt.GameOn.entity.Receipt;
import com.nonIt.GameOn.service.createdto.ReceiptDto;
import com.nonIt.GameOn.service.restdto.ReceiptRestDto;
import org.mapstruct.Mapper;

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
