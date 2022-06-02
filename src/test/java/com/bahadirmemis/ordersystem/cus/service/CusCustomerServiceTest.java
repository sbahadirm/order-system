package com.bahadirmemis.ordersystem.cus.service;

import com.bahadirmemis.ordersystem.cus.dto.CusCustomerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class CusCustomerServiceTest {

    @InjectMocks
    private CusCustomerService cusCustomerService;

    @Test
    void shouldFindCustomerById() {

        Optional<CusCustomerDto> customerDtoOptional = cusCustomerService.findCustomerById(1L);

        assertEquals(1L, customerDtoOptional.get().getId());
    }

    @Test
    void shouldNotFindCustomerById() {

        Optional<CusCustomerDto> customerDtoOptional = cusCustomerService.findCustomerById(-1L);

        assertFalse(customerDtoOptional.isPresent());
    }

    @Test
    void shouldFindCustomerByUsername() {

        Optional<CusCustomerDto> customerDtoOptional = cusCustomerService.findCustomerByUsername("sbahadir");

        assertEquals("sbahadir", customerDtoOptional.get().getUsername());
    }

    @Test
    void shouldNotFindCustomerByUsername() {

        Optional<CusCustomerDto> customerDtoOptional = cusCustomerService.findCustomerByUsername("ZZZ");

        assertFalse(customerDtoOptional.isPresent());
    }
}