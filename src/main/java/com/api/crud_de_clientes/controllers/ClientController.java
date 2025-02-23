package com.api.crud_de_clientes.controllers;

import com.api.crud_de_clientes.dtos.ClientRequestDTO;
import com.api.crud_de_clientes.dtos.ClientRequestToUpdateDTO;
import com.api.crud_de_clientes.dtos.ClientResponseDTO;
import com.api.crud_de_clientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO clientResponseDTO = clientService.createClient(clientRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(clientResponseDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(clientResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> retrieveClientById(@PathVariable Long id) {
        ClientResponseDTO clientResponseDTO = clientService.retrieveClientById(id);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponseDTO>> listAllClients(Pageable pageable) {
        Page<ClientResponseDTO> clientResponseDTOList = clientService.listAllClients(pageable);
        return ResponseEntity.ok().body(clientResponseDTOList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientRequestToUpdateDTO clientRequestDTO) {
        ClientResponseDTO clientResponseDTO = clientService.updateClient(id, clientRequestDTO);
        return ResponseEntity.ok().body(clientResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
