package com.bahadirmemis.ordersystem.ord.dao;

import com.bahadirmemis.ordersystem.ord.entity.OrdOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public interface OrdOrderProductDao extends JpaRepository<OrdOrderProduct, Long> {

    List<OrdOrderProduct> findAllByOrdOrderId(Long ordOrderId);
}
