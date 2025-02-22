package com.api.crud_de_clientes.controllers;

import com.api.crud_de_clientes.dtos.ClientResponseDTO;
import com.api.crud_de_clientes.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        ClientResponseDTO clientResponseDTO = clientService.getClientById(id);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

}
