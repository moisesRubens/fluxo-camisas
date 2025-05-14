package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.shirt.ShirtResponseDTO;
import com.rosadesaron.fluxo_camisa.repository.ShirtRepository;
import com.rosadesaron.fluxo_camisa.service.ShirtService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fluxo/shirt")
public class ShirtController {
    @Autowired
    private ShirtService shirtService;

    @Autowired
    private ShirtRepository shirtRepository;


    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Shirt> create(@RequestParam("size") char size,
                                        @RequestParam("quantity") int quantity,
                                        @RequestParam("sleeve") boolean sleeve,
                                        @RequestParam("collar") boolean collar,
                                        @RequestParam("price") double price,
                                        @RequestParam("color") String color,
                                        @RequestParam(value = "img", required = false) MultipartFile img) {
        ShirtRequestDTO data = new ShirtRequestDTO(color, sleeve, collar, quantity, size, price, img);
        Shirt shirt = shirtService.create(data);
        return ResponseEntity.ok(shirt);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShirtResponseDTO>> getAllShirts(@RequestParam("page") int page, @RequestParam("size") int size) {
        return ResponseEntity.ok(shirtService.getAllShirts(page, size));
    }

    @GetMapping("/{brand}")
    public List<ShirtResponseDTO> getShirtsByBrand(@RequestParam("page") int page, @RequestParam("size") int size, @PathVariable double price) {
        return shirtService.getShirtsByPrice(page, size, price);
    }
}