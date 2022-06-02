package com.bahadirmemis.ordersystem.ord.service;

import com.bahadirmemis.ordersystem.gen.service.GenCounterService;
import com.bahadirmemis.ordersystem.ord.dto.OrdOrderDto;
import com.bahadirmemis.ordersystem.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.ordersystem.ord.entity.OrdOrder;
import com.bahadirmemis.ordersystem.ord.entity.OrdOrderProduct;
import com.bahadirmemis.ordersystem.ord.service.entityservice.OrdOrderEntityService;
import com.bahadirmemis.ordersystem.ord.service.entityservice.OrdOrderProductEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class OrdOrderServiceTest {

    @Mock
    private OrdOrderEntityService ordOrderEntityService;

    @Mock
    private OrdOrderProductEntityService ordOrderProductEntityService;

    @Mock
    private GenCounterService genCounterService;

    @InjectMocks
    private OrdOrderService ordOrderService;

    @Test
    void shouldSaveOrdOrder() {

        OrdOrder ordOrder = mock(OrdOrder.class);
        when(ordOrder.getId()).thenReturn(1L);

        OrdOrderProduct ordOrderProduct = mock(OrdOrderProduct.class);

        OrdOrderSaveRequestDto ordOrderSaveRequestDto = mock(OrdOrderSaveRequestDto.class);
        when(ordOrderSaveRequestDto.getProductIdList()).thenReturn(Arrays.asList(1L,2L));

        when(genCounterService.findNextNumberOfCounter(any())).thenReturn(1L);
        when(ordOrderEntityService.save(any())).thenReturn(ordOrder);
        when(ordOrderProductEntityService.save(any())).thenReturn(ordOrderProduct);

        OrdOrderDto ordOrderDto = ordOrderService.saveOrdOrder(ordOrderSaveRequestDto);

        assertEquals(2L, ordOrderDto.getProductIdList().size());
    }

    @Test
    void shouldGetOrdOrderById() {

        OrdOrder ordOrder = mock(OrdOrder.class);
        when(ordOrder.getAddressId()).thenReturn(1L);

        when(ordOrderEntityService.getByIdWithControl(anyLong())).thenReturn(ordOrder);

        OrdOrderDto ordOrderDto = ordOrderService.getOrdOrderById(1L);

        assertEquals(1L, ordOrderDto.getAddressId());
    }

    @Test
    void shouldGetOrdOrderByCustomerId() {

        OrdOrder ordOrder = mock(OrdOrder.class);
        List<OrdOrder> ordOrderList = new ArrayList<>();
        ordOrderList.add(ordOrder);

        when(ordOrderEntityService.findByCustomerId(anyLong())).thenReturn(ordOrderList);

        List<OrdOrderDto> ordOrderDtoList = ordOrderService.getOrdOrderByCustomerId(1L);

        assertEquals(ordOrderList.size(), ordOrderDtoList.size());
    }

    @Test
    void shouldFindAll() {

        OrdOrder ordOrder = mock(OrdOrder.class);
        List<OrdOrder> ordOrderList = new ArrayList<>();
        ordOrderList.add(ordOrder);

        when(ordOrderEntityService.findAll()).thenReturn(ordOrderList);

        List<OrdOrderDto> ordOrderDtoList = ordOrderService.findAll();

        assertEquals(ordOrderList.size(), ordOrderDtoList.size());

    }

    @Test
    void shouldDelete() {

        OrdOrderProduct ordOrderProduct = mock(OrdOrderProduct.class);
        List<OrdOrderProduct> ordOrderProductList = new ArrayList<>();
        ordOrderProductList.add(ordOrderProduct);

        OrdOrder ordOrder = mock(OrdOrder.class);

        when(ordOrderProductEntityService.findAllByOrdOrderId(anyLong())).thenReturn(ordOrderProductList);
        doNothing().when(ordOrderProductEntityService).delete(any());
        when(ordOrderEntityService.getByIdWithControl(anyLong())).thenReturn(ordOrder);
        doNothing().when(ordOrderEntityService).delete(any());

        ordOrderService.delete(1L);
    }

    @Test
    void shouldCancelOrdOrder() {

        OrdOrder ordOrder = mock(OrdOrder.class);

        when(ordOrderEntityService.getByIdWithControl(anyLong())).thenReturn(ordOrder);
        when(ordOrderEntityService.save(any())).thenReturn(ordOrder);

        ordOrderService.cancelOrdOrder(1L);

        verify(ordOrder, times(1)).setDeliveryStatus(any());
    }
}