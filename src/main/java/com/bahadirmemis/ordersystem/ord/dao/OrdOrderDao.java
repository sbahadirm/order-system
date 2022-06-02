package com.bahadirmemis.ordersystem.ord.dao;

import com.bahadirmemis.ordersystem.ord.entity.OrdOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public interface OrdOrderDao extends JpaRepository<OrdOrder, Long> {

    List<OrdOrder> findByCustomerIdOrderById(Long customerId);
}
