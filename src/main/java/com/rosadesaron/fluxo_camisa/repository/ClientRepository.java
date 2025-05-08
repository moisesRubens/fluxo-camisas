package com.rosadesaron.fluxo_camisa.repository;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Query(
            "SELECT e FROM Client e WHERE e.name = :name AND e.email = :email"
    )
    public Client findClient(String name, String email);

}
