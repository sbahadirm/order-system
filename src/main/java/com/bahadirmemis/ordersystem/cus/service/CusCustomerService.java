package com.bahadirmemis.ordersystem.cus.service;

import com.bahadirmemis.ordersystem.cus.dto.CusCustomerDto;
import com.bahadirmemis.ordersystem.cus.helper.CusCustomerHelper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
public class CusCustomerService {

    public Optional<CusCustomerDto> findCustomerById(Long id){

        Optional<CusCustomerDto> customerDtoOptional = CusCustomerHelper.getAllCustomerList().stream()
                .filter(cusCustomerDto -> cusCustomerDto.getId().equals(id))
                .findFirst();

        return customerDtoOptional;
    }

    public Optional<CusCustomerDto> findCustomerByUsername(String username){

        Optional<CusCustomerDto> customerDtoOptional = CusCustomerHelper.getAllCustomerList().stream()
                .filter(cusCustomerDto -> cusCustomerDto.getUsername().equals(username))
                .findFirst();

        return customerDtoOptional;
    }
}
