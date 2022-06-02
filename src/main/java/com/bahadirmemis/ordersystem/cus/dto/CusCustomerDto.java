package com.bahadirmemis.ordersystem.cus.dto;

import com.bahadirmemis.ordersystem.cus.enums.EnumCusCustomerType;
import lombok.Builder;
import lombok.Data;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Data
@Builder
public class CusCustomerDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String email;
    private EnumCusCustomerType customerType;

}
