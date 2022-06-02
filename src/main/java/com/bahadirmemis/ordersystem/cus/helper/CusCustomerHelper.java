package com.bahadirmemis.ordersystem.cus.helper;

import com.bahadirmemis.ordersystem.cus.dto.CusCustomerDto;
import com.bahadirmemis.ordersystem.cus.enums.EnumCusCustomerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class CusCustomerHelper {

    public static List<CusCustomerDto> getAllCustomerList(){

        CusCustomerDto sadik = CusCustomerDto.builder()
                .id(1L)
                .name("sadik")
                .surname("bahadir")
                .username("sbahadir")
                .customerType(EnumCusCustomerType.CUSTOMER)
                .email("sadik@bahadir.com")
                .phoneNumber("5111111111")
                .build();

        CusCustomerDto yusuf = CusCustomerDto.builder()
                .id(2L)
                .name("yusuf")
                .surname("bahadir")
                .username("ybahadir")
                .customerType(EnumCusCustomerType.CUSTOMER)
                .email("yusuf@bahadir.com")
                .phoneNumber("5222222222")
                .build();

        CusCustomerDto ayse = CusCustomerDto.builder()
                .id(3L)
                .name("ayse")
                .surname("sadik")
                .username("asadik")
                .customerType(EnumCusCustomerType.VENDOR)
                .email("ayse@sadik.com")
                .phoneNumber("5333333333")
                .build();

        List<CusCustomerDto> cusCustomerDtoList = new ArrayList<>();
        Collections.addAll(cusCustomerDtoList, sadik, yusuf, ayse);

        return cusCustomerDtoList;
    }
}
