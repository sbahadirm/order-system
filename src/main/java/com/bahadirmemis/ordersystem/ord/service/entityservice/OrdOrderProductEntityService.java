package com.bahadirmemis.ordersystem.ord.service.entityservice;

import com.bahadirmemis.ordersystem.gen.service.BaseEntityService;
import com.bahadirmemis.ordersystem.ord.dao.OrdOrderProductDao;
import com.bahadirmemis.ordersystem.ord.entity.OrdOrderProduct;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class OrdOrderProductEntityService extends BaseEntityService<OrdOrderProduct, OrdOrderProductDao> {

    public OrdOrderProductEntityService(OrdOrderProductDao dao) {
        super(dao);
    }

    public List<OrdOrderProduct> findAllByOrdOrderId(Long ordOrderId){
        return getDao().findAllByOrdOrderId(ordOrderId);
    }
}
