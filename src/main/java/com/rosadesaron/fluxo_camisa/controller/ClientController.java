package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import com.rosadesaron.fluxo_camisa.domain.client.ClientRequestDTO;
import com.rosadesaron.fluxo_camisa.domain.client.ClientResponseDTO;
import com.rosadesaron.fluxo_camisa.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fluxo/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@RequestBody ClientRequestDTO data) {
        Client client = clientService.create(data);
        ClientResponseDTO clientData = new ClientResponseDTO(client.getName(), client.getEmail(), client.getId());
        return ResponseEntity.ok(clientData);
    }
}
