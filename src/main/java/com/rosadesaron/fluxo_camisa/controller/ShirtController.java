package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtResponseDTO;
import com.rosadesaron.fluxo_camisa.service.ShirtService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ShirtController {
    @Autowired
    private ShirtService shirtService;

    //A CONCLUIR
    @PostMapping("/fluxo/shirt")
    public ResponseEntity<ShirtResponseDTO> create(@RequestBody ShirtRequestDTO data) {
        ShirtResponseDTO shirtResponse = new ShirtResponseDTO();
        return ResponseEntity.ok(shirtResponse);
    }
}
