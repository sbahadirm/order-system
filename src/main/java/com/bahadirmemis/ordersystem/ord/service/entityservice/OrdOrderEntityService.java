package com.bahadirmemis.ordersystem.ord.service.entityservice;

import com.bahadirmemis.ordersystem.gen.service.BaseEntityService;
import com.bahadirmemis.ordersystem.ord.dao.OrdOrderDao;
import com.bahadirmemis.ordersystem.ord.entity.OrdOrder;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class OrdOrderEntityService extends BaseEntityService<OrdOrder, OrdOrderDao> {

    public OrdOrderEntityService(OrdOrderDao dao) {
        super(dao);
    }

    public List<OrdOrder> findByCustomerId(Long customerId){
        return getDao().findByCustomerIdOrderById(customerId);
    }
}
