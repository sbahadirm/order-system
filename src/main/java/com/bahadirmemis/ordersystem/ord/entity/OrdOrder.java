package com.bahadirmemis.ordersystem.ord.entity;

import com.bahadirmemis.ordersystem.gen.entity.BaseEntity;
import com.bahadirmemis.ordersystem.ord.enums.EnumOrdDeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Entity
@Table(name = "ORD_ORDER")
@Getter
@Setter
public class OrdOrder extends BaseEntity {

    @Id
    @SequenceGenerator(name = "OrdOrder", sequenceName = "ORD_ORDER_ID_SEQ")
    @GeneratedValue(generator = "OrdOrder")
    private Long id;

    private Long customerId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column(name = "PAID_AMOUNT", precision = 19, scale = 2)
    private BigDecimal paidAmount;

    private String deliveryCompany;

    private String parcelTrackingCode;

    private Long addressId;

    @Enumerated(EnumType.STRING)
    @Column(name = "DELIVERY_STATUS", length = 30)
    private EnumOrdDeliveryStatus deliveryStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;

    private Long orderNo;
}
