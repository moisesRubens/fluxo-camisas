package com.rosadesaron.fluxo_camisa.domain.order;

import java.util.UUID;

public record ItemOrderRequestDTO(Integer quantity, UUID idShirt) {
}
