package com.bahadirmemis.ordersystem.prd.service;

import com.bahadirmemis.ordersystem.prd.helper.PrdProductHelper;
import com.bahadirmemis.ordersystem.prd.dto.PrdProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
public class PrdProductService {

    public List<PrdProductDto> findAllProductList(){

        List<PrdProductDto> allProductList = PrdProductHelper.getAllProductList();

        return allProductList;
    }

    public Optional<PrdProductDto> findProductById(Long id){

        List<PrdProductDto> allProductList = PrdProductHelper.getAllProductList();

        Optional<PrdProductDto> productDtoOptional = allProductList.stream()
                .filter(prdProductDto -> prdProductDto.getId().equals(id))
                .findFirst();

        return productDtoOptional;
    }
}
