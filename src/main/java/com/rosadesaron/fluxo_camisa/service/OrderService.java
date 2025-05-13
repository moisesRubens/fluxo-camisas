package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import com.rosadesaron.fluxo_camisa.domain.order.ItemOrder;
import com.rosadesaron.fluxo_camisa.domain.order.Order;
import com.rosadesaron.fluxo_camisa.domain.order.ItemOrderRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.order.OrderRequestDTO;
import com.rosadesaron.fluxo_camisa.repository.ClientRepository;
import com.rosadesaron.fluxo_camisa.repository.OrderRepository;
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

    public Order generateOrder(OrderRequestDTO data) throws IllegalArgumentException {
        Order order = new Order();
        order.setDate(new Date(data.date()));

        Client client = clientRepository.findById(data.idClient())
                .orElseThrow(() -> new NoSuchElementException("Id de cliente invalido"));
        order.setClient(client);

        double totalValue = 0.0;
        for(ItemOrderRequestDTO dto : data.items()) {
            ItemOrder itemOrder = itemOrderService.create(dto);
            order.addItemOrder(itemOrder);
            totalValue += itemOrder.getUnitValue()* itemOrder.getQuantity();
        }
        order.setTotalValue(totalValue);
        return orderRepository.save(order);
    }
}
