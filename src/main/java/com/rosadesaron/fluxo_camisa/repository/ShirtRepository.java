package com.rosadesaron.fluxo_camisa.repository;

import com.rosadesaron.fluxo_camisa.domain.shirt.Shirt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ShirtRepository extends JpaRepository<Shirt, UUID> {
    @Query("SELECT FROM Shirt WHERE price <= :price")
    public Page<Shirt> getShirtsByPrice(Pageable pageable, double price);
}
