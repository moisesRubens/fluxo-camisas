package com.rosadesaron.fluxo_camisa.repository;

import com.rosadesaron.fluxo_camisa.domain.order.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, UUID> {
}
