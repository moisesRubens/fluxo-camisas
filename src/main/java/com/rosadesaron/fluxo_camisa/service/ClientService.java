package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import com.rosadesaron.fluxo_camisa.domain.client.ClientRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.client.ClientResponseDTO;
import com.rosadesaron.fluxo_camisa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public ClientResponseDTO getClient(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
        return new ClientResponseDTO(client.getName(), client.getEmail(), client.getId());
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteAllById(Collections.singleton(id));
    }
}
