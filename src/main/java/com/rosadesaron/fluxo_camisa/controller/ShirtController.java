package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.domain.shirt.RequestShirtDTO;
import com.rosadesaron.fluxo_camisa.service.ShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ShirtController {
    @Autowired
    private ShirtService shirtService;

    @PostMapping("/fluxo/shirt")
    public ResponseEntity<Shirt> create(@RequestBody RequestShirtDTO data) {
        Shirt shirt = shirtService.create(data);
        return ResponseEntity.ok(shirt);
    }
}
