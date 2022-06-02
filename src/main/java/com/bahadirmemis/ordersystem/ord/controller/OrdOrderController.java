package com.bahadirmemis.ordersystem.ord.controller;

import com.bahadirmemis.ordersystem.ord.dto.OrdOrderDto;
import com.bahadirmemis.ordersystem.ord.dto.OrdOrderSaveRequestDto;
import com.bahadirmemis.ordersystem.ord.service.OrdOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin
public class OrdOrderController {

    private final OrdOrderService ordOrderService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody OrdOrderSaveRequestDto ordOrderSaveRequestDto){

        OrdOrderDto ordOrderDto = ordOrderService.saveOrdOrder(ordOrderSaveRequestDto);

        return ResponseEntity.ok(ordOrderDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrdOrderById(@PathVariable Long id){

        OrdOrderDto ordOrder = ordOrderService.getOrdOrderById(id);

        return ResponseEntity.ok(ordOrder);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity getOrdOrderByCustomerId(@PathVariable Long customerId){

        List<OrdOrderDto> ordOrderDtoList = ordOrderService.getOrdOrderByCustomerId(customerId);

        return ResponseEntity.ok(ordOrderDtoList);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<OrdOrderDto> ordOrderDtoList = ordOrderService.findAll();

        return ResponseEntity.ok(ordOrderDtoList);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        ordOrderService.delete(id);
    }
}
