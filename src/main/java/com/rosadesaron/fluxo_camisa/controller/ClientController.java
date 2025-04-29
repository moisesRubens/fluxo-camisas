package com.rosadesaron.fluxo_camisa.controller;

import com.rosadesaron.fluxo_camisa.domain.client.Client;
import com.rosadesaron.fluxo_camisa.domain.client.RequestClientDTO;
import com.rosadesaron.fluxo_camisa.domain.client.ResponseClientDTO;
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
    public ResponseEntity<ResponseClientDTO> create(@RequestBody RequestClientDTO data) {
        Client client = clientService.create(data);
        ResponseClientDTO clientData = new ResponseClientDTO(client.getName(), client.getEmail(), client.getId());
        return ResponseEntity.ok(clientData);
    }
}
