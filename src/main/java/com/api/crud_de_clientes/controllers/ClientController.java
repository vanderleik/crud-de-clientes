package com.api.crud_de_clientes.controllers;

import com.api.crud_de_clientes.dtos.ClientResponseDTO;
import com.api.crud_de_clientes.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> retrieveClientById(@PathVariable Long id) {
        ClientResponseDTO clientResponseDTO = clientService.retrieveClientById(id);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> listAllClients() {
        List<ClientResponseDTO> clientResponseDTOList = clientService.listAllClients();
        return ResponseEntity.ok().body(clientResponseDTOList);
    }

}
