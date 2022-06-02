package com.bahadirmemis.ordersystem.prd.helper;

import com.bahadirmemis.ordersystem.prd.dto.PrdProductDto;
import com.bahadirmemis.ordersystem.prd.enums.EnumPrdProductCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class PrdProductHelper {

    public static List<PrdProductDto> getAllProductList(){

        PrdProductDto apple = PrdProductDto.builder()
                .id(1L)
                .productCode(EnumPrdProductCode.FOOD.getProductCode())
                .name("Elma")
                .price(BigDecimal.TEN)
                .build();

        PrdProductDto pear = PrdProductDto.builder()
                .id(2L)
                .productCode(EnumPrdProductCode.FOOD.getProductCode())
                .name("Armut")
                .price(BigDecimal.valueOf(12))
                .build();

        PrdProductDto water = PrdProductDto.builder()
                .id(3L)
                .productCode(EnumPrdProductCode.DRINK.getProductCode())
                .name("Su")
                .price(BigDecimal.valueOf(5))
                .build();

        PrdProductDto cola = PrdProductDto.builder()
                .id(4L)
                .productCode(EnumPrdProductCode.DRINK.getProductCode())
                .name("Kola")
                .price(BigDecimal.valueOf(15))
                .build();

        List<PrdProductDto> prdProductDtoList = new ArrayList<>();
        Collections.addAll(prdProductDtoList, apple, pear, water, cola);

        return prdProductDtoList;
    }
}
