package com.bahadirmemis.ordersystem.gen.dao;

import com.bahadirmemis.ordersystem.gen.entity.GenCounter;
import com.bahadirmemis.ordersystem.gen.enums.EnumGenCounterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenCounterDao extends JpaRepository<GenCounter, Long> {

    GenCounter findByCounterType(EnumGenCounterType counterType);
}
