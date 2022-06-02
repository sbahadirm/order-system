package com.bahadirmemis.ordersystem.ord.converter;

import com.bahadirmemis.ordersystem.ord.dto.OrdOrderDto;
import com.bahadirmemis.ordersystem.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.ordersystem.ord.entity.OrdOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrdOrderMapper {

    OrdOrderMapper INSTANCE = Mappers.getMapper(OrdOrderMapper.class);

    OrdOrder convertToOrdOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto);

    OrdOrderDto convertToOrdOrderDto(OrdOrder ordOrder);

    List<OrdOrderDto> convertToOrdOrderDtoList(List<OrdOrder> ordOrderList);
}
