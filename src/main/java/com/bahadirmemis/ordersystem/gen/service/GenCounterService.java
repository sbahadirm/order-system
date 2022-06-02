package com.bahadirmemis.ordersystem.gen.service;

import com.bahadirmemis.ordersystem.gen.entity.GenCounter;
import com.bahadirmemis.ordersystem.gen.enums.EnumGenCounterType;
import com.bahadirmemis.ordersystem.gen.service.entityservice.GenCounterEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class GenCounterService {

    private final GenCounterEntityService genCounterEntityService;

    public synchronized Long findNextNumberOfCounter(EnumGenCounterType counterType) {

        GenCounter genCounter = genCounterEntityService.findOrCreateGenCounter(counterType);

        Long lastNum = genCounter.getLastNum();

        Long newLastNum = lastNum + 1L;

        genCounter.setLastNum(newLastNum);

        genCounter = genCounterEntityService.save(genCounter);

        return newLastNum;
    }
}
