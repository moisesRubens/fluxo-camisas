package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.configuration.InsufficientStockException;
import com.rosadesaron.fluxo_camisa.domain.order.Order;
import com.rosadesaron.fluxo_camisa.domain.order.RequestOrderDTO;
import com.rosadesaron.fluxo_camisa.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fluxo/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public Order doOrder(RequestOrderDTO data) throws InsufficientStockException {
        return orderService.generateOrder(data);
    }
}
