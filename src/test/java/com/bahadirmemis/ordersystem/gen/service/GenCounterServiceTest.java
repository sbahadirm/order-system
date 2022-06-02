package com.bahadirmemis.ordersystem.gen.service;

import com.bahadirmemis.ordersystem.gen.entity.GenCounter;
import com.bahadirmemis.ordersystem.gen.enums.EnumGenCounterType;
import com.bahadirmemis.ordersystem.gen.service.entityservice.GenCounterEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class GenCounterServiceTest {

    @Mock
    private GenCounterEntityService genCounterEntityService;

    @InjectMocks
    private GenCounterService genCounterService;

    @Test
    void shouldFindNextNumberOfCounter() {

        GenCounter genCounter = Mockito.mock(GenCounter.class);
        when(genCounter.getLastNum()).thenReturn(5L);

        when(genCounterEntityService.findOrCreateGenCounter(any())).thenReturn(genCounter);
        when(genCounterEntityService.save(any())).thenReturn(genCounter);

        Long counter = genCounterService.findNextNumberOfCounter(EnumGenCounterType.ORDER_NUM);

        assertEquals(6L, counter);
    }
}