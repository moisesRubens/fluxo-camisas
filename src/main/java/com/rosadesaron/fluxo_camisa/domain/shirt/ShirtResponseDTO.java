package com.rosadesaron.fluxo_camisa.domain.shirt;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public record ShirtResponseDTO(boolean sleeve, boolean collar, String color,
                               double price, int quantity, int size, UUID id,
                               String imgUrl) {
}
