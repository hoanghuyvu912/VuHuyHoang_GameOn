package com.nonIt.GameOn.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface EntityMapper<RD, E, D> {
    RD toDto(E entity);

    List<RD> toDtos(List<E> entityList);

    E toEntity(RD dto);

    List<E> toEntities(List<RD> dtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(D d, @MappingTarget E entity);
}
