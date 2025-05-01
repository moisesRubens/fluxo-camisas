package com.rosadesaron.fluxo_camisa.domain.shirt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "shirt")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shirt {
    @Id
    @GeneratedValue
    private UUID id;

    private String imgUrl;
    private int quantity;
    private char size;
    private Boolean collar;
    private Boolean sleeve;
    private double price;
    private String color;


}
