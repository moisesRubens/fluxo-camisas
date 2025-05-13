package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.domain.order.ItemOrder;
import com.rosadesaron.fluxo_camisa.domain.order.ItemOrderRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.repository.ItemOrderRepository;
import com.rosadesaron.fluxo_camisa.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ItemOrderService {

    @Autowired
    private ItemOrderRepository itemOrderRepository;

    @Autowired
    private ShirtRepository shirtRepository;

    public ItemOrder create(ItemOrderRequestDTO data) {
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setQuantity(data.quantity());

        Shirt shirt = shirtRepository.findById(data.idShirt())
                .orElseThrow(() -> new NoSuchElementException("id da camisa nao encontrado"));
        itemOrder.setShirt(shirt);
        itemOrder.setUnitValue(shirt.getPrice());

        itemOrderRepository.save(itemOrder);
        return itemOrder;
    }
}
