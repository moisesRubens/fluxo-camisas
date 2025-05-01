package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtResponseDTO;
import com.rosadesaron.fluxo_camisa.service.ShirtService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
public class ShirtController {
    @Autowired
    private ShirtService shirtService;

    @PostMapping("/fluxo/shirt")
    public ResponseEntity<Shirt> create(@RequestParam("size")char size,
                                        @RequestParam("quantity")int quantity,
                                        @RequestParam("sleeve") boolean sleeve,
                                        @RequestParam("collar")boolean collar,
                                        @RequestParam("price")double price,
                                        @RequestParam("color")String color,
                                        @RequestParam(value = "img", required = false)MultipartFile img) {
        ShirtRequestDTO data = new ShirtRequestDTO(color, sleeve, collar, quantity, size, price, img);
        return ResponseEntity.ok(shirtService.create(data));
    }
}
