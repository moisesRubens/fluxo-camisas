package com.rosadesaron.fluxo_camisa.domain.order;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "client_id")
    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ItemOrder> items = new ArrayList<>();

    private Date date;
    private Double totalValue;

    public void addItemOrder(ItemOrder itemOrder) {
        itemOrder.setOrder(this);
        this.items.add(itemOrder);
    }
}
