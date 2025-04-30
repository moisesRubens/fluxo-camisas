package com.rosadesaron.fluxo_camisa.domain.order;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record OrderResponseDTO(UUID id, UUID idClient, List<ItemOrderResponseDTO> items, double totalValue, Date purchaseDate) {
}
