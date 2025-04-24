package com.rosadesaron.fluxo_camisa.domain.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "order")
@AllArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    private Date date;
    private Double totalValue;
}
