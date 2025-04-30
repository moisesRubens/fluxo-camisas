package com.rosadesaron.fluxo_camisa.domain.order;

import java.util.UUID;

public record ItemOrderResponseDTO(UUID idItemOrder, UUID idShirt, int quantity, double unitValue) {
}
