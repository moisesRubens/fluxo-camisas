package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.configuration.InsufficientStockException;
import com.rosadesaron.fluxo_camisa.domain.client.Client;
import com.rosadesaron.fluxo_camisa.domain.client.RequestClientDTO;
import com.rosadesaron.fluxo_camisa.domain.order.ItemOrder;
import com.rosadesaron.fluxo_camisa.domain.order.Order;
import com.rosadesaron.fluxo_camisa.domain.order.RequestItemOrderDTO;
import com.rosadesaron.fluxo_camisa.domain.order.RequestOrderDTO;
import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.repository.ClientRepository;
import com.rosadesaron.fluxo_camisa.repository.ItemOrderRepository;
import com.rosadesaron.fluxo_camisa.repository.OrderRepository;
import com.rosadesaron.fluxo_camisa.repository.ShirtRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ItemOrderService itemOrderService;

    public Order generateOrder(RequestOrderDTO data) throws IllegalArgumentException {
        Order order = new Order();
        order.setDate(new Date(data.date()));

        Client client = clientRepository.findById(data.idClient())
                .orElseThrow(() -> new IllegalArgumentException("Id de cliente invalido"));
        order.setClient(client);

        double totalValue = 0.0;
        for(RequestItemOrderDTO dto : data.items()) {
            ItemOrder itemOrder = itemOrderService.create(dto);
            order.addItemOrder(itemOrder);
            totalValue += itemOrder.getUnitValue()* itemOrder.getQuantity();
        }
        order.setTotalValue(totalValue);
        return orderRepository.save(order);
    }
}
