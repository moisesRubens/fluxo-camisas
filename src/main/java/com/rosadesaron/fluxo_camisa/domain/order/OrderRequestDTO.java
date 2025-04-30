package com.rosadesaron.fluxo_camisa.domain.order;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(Long date, UUID idClient, List<ItemOrderRequestDTO> items) {
}
