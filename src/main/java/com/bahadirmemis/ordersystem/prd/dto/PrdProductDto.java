package com.bahadirmemis.ordersystem.prd.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
@Builder
public class PrdProductDto {

    private Long id;
    private String name;
    private String productCode;
    private BigDecimal price;
}
