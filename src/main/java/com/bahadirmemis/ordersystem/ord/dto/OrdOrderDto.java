package com.bahadirmemis.ordersystem.ord.dto;

import com.bahadirmemis.ordersystem.ord.enums.EnumOrdDeliveryStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
public class OrdOrderDto {

    private Date orderDate;
    private BigDecimal paidAmount;
    private String deliveryCompany;
    private String parcelTrackingCode;
    private Long addressId;
    private EnumOrdDeliveryStatus deliveryStatus;
    private Date deliveryDate;
    private Long orderNo;
    private List<Long> productIdList;
}
