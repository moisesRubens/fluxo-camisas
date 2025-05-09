package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import com.rosadesaron.fluxo_camisa.domain.client.ClientRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.client.ClientResponseDTO;
import com.rosadesaron.fluxo_camisa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client create(ClientRequestDTO data) {
        Client client = new Client();
        client.setName(data.name());
        client.setEmail(data.email());
        clientRepository.save(client);
        return client;
    }

    public ClientResponseDTO getClient(String name, String email) {
        Client client = clientRepository.findClient(name, email);
        return new ClientResponseDTO(client.getName(), client.getEmail(), client.getId());
    }

    public ClientResponseDTO getClientById(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        return new ClientResponseDTO(client.getName(), client.getEmail(), client.getId());
    }
}
