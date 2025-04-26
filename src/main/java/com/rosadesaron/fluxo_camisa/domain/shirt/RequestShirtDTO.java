package com.rosadesaron.fluxo_camisa.domain.shirt;

public record RequestShirtDTO(String color, Boolean sleeve, Boolean collar, Integer quantity, Integer size, Double price) {
}
