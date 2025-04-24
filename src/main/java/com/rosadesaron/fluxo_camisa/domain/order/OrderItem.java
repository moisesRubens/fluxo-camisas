package com.rosadesaron.fluxo_camisa.domain.order;

import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "order_item")
@Getter
@Setter

public class OrderItem {
    @Id
    private UUID id;

    @JoinColumn(name = "shirt_id")
    @ManyToOne
    private Shirt shirt;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order order;

    private Double unitValue;
    private Integer quantity;
}
