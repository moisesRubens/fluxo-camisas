package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.configuration.InsufficientStockException;
import com.rosadesaron.fluxo_camisa.domain.order.*;
import com.rosadesaron.fluxo_camisa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fluxo/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> generateOrder(OrderRequestDTO data) {
        Order order = orderService.generateOrder(data);
        List<ItemOrderResponseDTO> itemOrderResponseDTOList = new ArrayList<>();

        for(ItemOrder itemOrder : order.getItems()) {
            ItemOrderResponseDTO itemOrderResponseDTO = new ItemOrderResponseDTO(itemOrder.getId(), itemOrder.getShirt().getId(),
                                                                                itemOrder.getQuantity(), itemOrder.getUnitValue());
            itemOrderResponseDTOList.add(itemOrderResponseDTO);
        }
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO(order.getId(), order.getClient().getId(),
                                                                itemOrderResponseDTOList, order.getTotalValue(),
                                                                order.getDate());

        return ResponseEntity.ok(orderResponseDTO);
    }
}
