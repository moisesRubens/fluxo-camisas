package com.rosadesaron.fluxo_camisa.service;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import com.rosadesaron.fluxo_camisa.domain.client.RequestClientDTO;
import com.rosadesaron.fluxo_camisa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client create(RequestClientDTO data) {
        Client client = new Client();
        client.setName(data.name());
        client.setEmail(data.email());
        clientRepository.save(client);
        return client;
    }
}
