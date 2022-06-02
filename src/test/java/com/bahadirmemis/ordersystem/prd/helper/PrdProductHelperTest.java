package com.bahadirmemis.ordersystem.prd.helper;

import com.bahadirmemis.ordersystem.cus.dto.CusCustomerDto;
import com.bahadirmemis.ordersystem.cus.helper.CusCustomerHelper;
import com.bahadirmemis.ordersystem.prd.dto.PrdProductDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
class PrdProductHelperTest {

    @Test
    void shouldGetAllProductList() {

        List<PrdProductDto> prdProductDtoList = PrdProductHelper.getAllProductList();

        assertEquals(4L, prdProductDtoList.size());
    }
}