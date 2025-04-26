package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.domain.order.ItemOrder;
import com.rosadesaron.fluxo_camisa.domain.order.Order;
import com.rosadesaron.fluxo_camisa.domain.order.RequestItemOrderDTO;
import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.repository.ItemOrderRepository;
import com.rosadesaron.fluxo_camisa.repository.OrderRepository;
import com.rosadesaron.fluxo_camisa.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderService {

    @Autowired
    private ItemOrderRepository itemOrderRepository;

    @Autowired
    private ShirtRepository shirtRepository;

    @Autowired
    private OrderRepository orderRepository;

    public ItemOrder create(RequestItemOrderDTO data) {
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setQuantity(data.quantity());

        Shirt shirt = shirtRepository.findById(data.idShirt())
                .orElseThrow(() -> new IllegalArgumentException("id da camisa nao encontrado"));
        itemOrder.setShirt(shirt);
        itemOrder.setUnitValue(shirt.getPrice());
        return itemOrder;
    }
}
