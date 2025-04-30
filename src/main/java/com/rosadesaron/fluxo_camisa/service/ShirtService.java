package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtRequestDTO;
import com.rosadesaron.fluxo_camisa.repository.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShirtService {
    @Autowired
    ShirtRepository shirtRepository;

    public Shirt create(ShirtRequestDTO data) {
        Shirt shirt = new Shirt();

        shirt.setCollar(data.collar());
        shirt.setColor(data.color());
        shirt.setSize(data.size());
        shirt.setPrice(data.price());
        shirt.setQuantity(data.quantity());
        shirt.setSleeve(data.sleeve());
        return shirtRepository.save(shirt);
    }
}
