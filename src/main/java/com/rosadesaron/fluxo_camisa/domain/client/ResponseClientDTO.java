package com.rosadesaron.fluxo_camisa.domain.client;

import java.util.UUID;

public record ResponseClientDTO(String name, String email, UUID id) {
}
