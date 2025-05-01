package com.rosadesaron.fluxo_camisa.domain.shirt;

import org.springframework.web.multipart.MultipartFile;

public record ShirtRequestDTO(String color, boolean sleeve, boolean collar, int quantity,
                              char size, double price, MultipartFile img) {
}
