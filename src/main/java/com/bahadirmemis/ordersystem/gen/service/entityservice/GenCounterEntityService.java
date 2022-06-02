package com.bahadirmemis.ordersystem.gen.service.entityservice;

import com.bahadirmemis.ordersystem.gen.dao.GenCounterDao;
import com.bahadirmemis.ordersystem.gen.entity.GenCounter;
import com.bahadirmemis.ordersystem.gen.enums.EnumGenCounterType;
import com.bahadirmemis.ordersystem.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class GenCounterEntityService extends BaseEntityService<GenCounter, GenCounterDao> {

    public GenCounterEntityService(GenCounterDao dao) {
        super(dao);
    }

    public GenCounter findOrCreateGenCounter(EnumGenCounterType counterType){

        GenCounter genCounter = getDao().findByCounterType(counterType);

        if (genCounter == null){
            genCounter = new GenCounter();
            genCounter.setLastNum(0L);
            genCounter.setCounterType(counterType);
        }

        return genCounter;
    }
}
