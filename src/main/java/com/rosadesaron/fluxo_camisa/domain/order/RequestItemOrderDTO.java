package com.rosadesaron.fluxo_camisa.domain.order;

import java.util.UUID;

public record RequestItemOrderDTO(Integer quantity, UUID idShirt) {
}
