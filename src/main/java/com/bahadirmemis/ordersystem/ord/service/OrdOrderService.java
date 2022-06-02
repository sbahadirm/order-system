package com.bahadirmemis.ordersystem.ord.service;

import com.bahadirmemis.ordersystem.gen.enums.EnumGenCounterType;
import com.bahadirmemis.ordersystem.gen.service.GenCounterService;
import com.bahadirmemis.ordersystem.ord.converter.OrdOrderMapper;
import com.bahadirmemis.ordersystem.ord.dto.OrdOrderDto;
import com.bahadirmemis.ordersystem.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.ordersystem.ord.entity.OrdOrder;
import com.bahadirmemis.ordersystem.ord.entity.OrdOrderProduct;
import com.bahadirmemis.ordersystem.ord.enums.EnumOrdDeliveryStatus;
import com.bahadirmemis.ordersystem.ord.service.entityservice.OrdOrderEntityService;
import com.bahadirmemis.ordersystem.ord.service.entityservice.OrdOrderProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OrdOrderService {

    private final OrdOrderEntityService ordOrderEntityService;
    private final OrdOrderProductEntityService ordOrderProductEntityService;
    private final GenCounterService genCounterService;

    public OrdOrderDto saveOrdOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto) {

        OrdOrder ordOrder = saveNewOrder(ordOrderSaveRequestDto);

        List<Long> productIdList = ordOrderSaveRequestDto.getProductIdList();

        saveOrderProducts(ordOrder.getId(), productIdList);

        OrdOrderDto ordOrderDto = OrdOrderMapper.INSTANCE.convertToOrdOrderDto(ordOrder);
        ordOrderDto.setProductIdList(productIdList);

        return ordOrderDto;
    }

    public OrdOrderDto getOrdOrderById(Long id) {

        OrdOrder ordOrder = ordOrderEntityService.getByIdWithControl(id);

        OrdOrderDto ordOrderDto = OrdOrderMapper.INSTANCE
                .convertToOrdOrderDto(ordOrder);

        return ordOrderDto;
    }

    public List<OrdOrderDto> getOrdOrderByCustomerId(Long customerId) {

        List<OrdOrder> ordOrderList = ordOrderEntityService.findByCustomerId(customerId);

        List<OrdOrderDto> ordOrderDtoList = OrdOrderMapper.INSTANCE.convertToOrdOrderDtoList(ordOrderList);

        return ordOrderDtoList;
    }

    public List<OrdOrderDto> findAll() {

        List<OrdOrder> ordOrderList = ordOrderEntityService.findAll();

        List<OrdOrderDto> ordOrderDtoList = OrdOrderMapper.INSTANCE.convertToOrdOrderDtoList(ordOrderList);

        return ordOrderDtoList;
    }

    public void delete(Long orderId) {
        deleteOrderProductsOfOrder(orderId);
        deleteOrder(orderId);
    }

    private void saveOrderProducts(Long ordOrderId, List<Long> productIdList) {
        for (Long eachProductId : productIdList) {
            OrdOrderProduct ordOrderProduct = new OrdOrderProduct();
            ordOrderProduct.setOrdOrderId(ordOrderId);
            ordOrderProduct.setPrdProductId(eachProductId);
            ordOrderProductEntityService.save(ordOrderProduct);
        }
    }

    private OrdOrder saveNewOrder(OrdOrderSaveRequestDto ordOrderSaveRequestDto) {

        Long orderNumber = genCounterService.findNextNumberOfCounter(EnumGenCounterType.ORDER_NUM);
        Long parcelTrackingCode = genCounterService.findNextNumberOfCounter(EnumGenCounterType.PARCEL_TRACKING_CODE);

        OrdOrder ordOrder = OrdOrderMapper.INSTANCE.convertToOrdOrder(ordOrderSaveRequestDto);

        ordOrder.setOrderNo(orderNumber);
        ordOrder.setDeliveryStatus(EnumOrdDeliveryStatus.PREPARING);
        ordOrder.setParcelTrackingCode(String.valueOf(parcelTrackingCode));
        ordOrder = ordOrderEntityService.save(ordOrder);

        return ordOrder;
    }

    private void deleteOrder(Long id) {
        OrdOrder ordOrder = ordOrderEntityService.getByIdWithControl(id);
        ordOrderEntityService.delete(ordOrder);
    }

    private void deleteOrderProductsOfOrder(Long id) {
        List<OrdOrderProduct> productList = ordOrderProductEntityService.findAllByOrdOrderId(id);

        for (OrdOrderProduct ordOrderProduct : productList) {
            ordOrderProductEntityService.delete(ordOrderProduct);
        }
    }

    public void cancelOrdOrder(Long orderId) {

        OrdOrder ordOrder = ordOrderEntityService.getByIdWithControl(orderId);

        ordOrder.setDeliveryStatus(EnumOrdDeliveryStatus.CANCELLED);
        ordOrderEntityService.save(ordOrder);
    }
}
