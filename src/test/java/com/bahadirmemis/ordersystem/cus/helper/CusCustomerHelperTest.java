package com.bahadirmemis.ordersystem.cus.helper;

import com.bahadirmemis.ordersystem.cus.dto.CusCustomerDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class CusCustomerHelperTest {

    @Test
    void shouldGetAllCustomerList() {

        List<CusCustomerDto> cusCustomerDtoList = CusCustomerHelper.getAllCustomerList();

        assertEquals(3L, cusCustomerDtoList.size());
    }
}