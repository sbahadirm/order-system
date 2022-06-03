package com.bahadirmemis.ordersystem.ord.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
@Builder
public class OrdOrderSaveRequestDto {

    @NotNull
    private Long customerId;

    @PastOrPresent
    private Date orderDate;

    @Positive
    private BigDecimal paidAmount;

    private String deliveryCompany;
    private Long addressId;

    @NotEmpty(message = "Product list cannot be empty!")
    private List<Long> productIdList;
}
