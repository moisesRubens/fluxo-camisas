package com.rosadesaron.fluxo_camisa.domain.shirt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "shirt")
@Getter
@Setter
@AllArgsConstructor
public class Shirt {
    @Id
    @GeneratedValue
    private UUID id;

    private Integer quantity;
    private Integer size;
    private Boolean collar;
    private Boolean sleeve;
    private Double price;
    private String color;
}
