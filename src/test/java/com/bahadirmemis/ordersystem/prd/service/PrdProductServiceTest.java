package com.bahadirmemis.ordersystem.prd.service;

import com.bahadirmemis.ordersystem.prd.dto.PrdProductDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class PrdProductServiceTest {

    @InjectMocks
    private PrdProductService prdProductService;

    @Test
    void shouldFindAllProductList() {

        List<PrdProductDto> prdProductDtoList = prdProductService.findAllProductList();

        assertEquals(4L, prdProductDtoList.size());
    }

    @Test
    void shouldFindProductById() {

        Optional<PrdProductDto> productDtoOptional = prdProductService.findProductById(1L);

        assertEquals(1L, productDtoOptional.get().getId());
    }

    @Test
    void shouldNotFindProductById() {

        Optional<PrdProductDto> productDtoOptional = prdProductService.findProductById(-1L);

        assertFalse(productDtoOptional.isPresent());
    }
}