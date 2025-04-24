package com.rosadesaron.fluxo_camisa.domain.client;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Table(name = "client")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
}
