package com.bahadirmemis.ordersystem.ord.entity;

import com.bahadirmemis.ordersystem.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORD_ORDER_PRODUCT")
@Getter
@Setter
public class OrdOrderProduct extends BaseEntity {

    @Id
    @SequenceGenerator(name = "OrdOrderProduct", sequenceName = "ORD_ORDER_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "OrdOrderProduct")
    private Long id;

    private Long ordOrderId;

    private Long prdProductId;
}
