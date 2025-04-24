package com.rosadesaron.fluxo_camisa.repository;

import com.rosadesaron.fluxo_camisa.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
