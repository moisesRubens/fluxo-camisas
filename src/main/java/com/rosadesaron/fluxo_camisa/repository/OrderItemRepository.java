package com.rosadesaron.fluxo_camisa.repository;

import com.rosadesaron.fluxo_camisa.domain.order.Order;
import com.rosadesaron.fluxo_camisa.domain.order.OrderItem;
import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
