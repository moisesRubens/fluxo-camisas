package com.rosadesaron.fluxo_camisa.repository;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
