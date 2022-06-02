package com.bahadirmemis.ordersystem.gen.entity;

import com.bahadirmemis.ordersystem.gen.enums.EnumGenCounterType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "GEN_COUNTER")
public class GenCounter extends BaseEntity{

    @Id
    @SequenceGenerator(name = "GenCounter", sequenceName = "GEN_COUNTER_ID_SEQ")
    @GeneratedValue(generator = "GenCounter")
    private Long id;

    private Long lastNum;

    @Enumerated(EnumType.STRING)
    private EnumGenCounterType counterType;

}
