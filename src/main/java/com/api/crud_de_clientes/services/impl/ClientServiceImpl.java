package com.api.crud_de_clientes.services.impl;

import com.api.crud_de_clientes.dtos.ClientResponseDTO;
import com.api.crud_de_clientes.entities.Client;
import com.api.crud_de_clientes.repositories.ClientRepository;
import com.api.crud_de_clientes.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDTO getClientById(Long id) {
        Client clientReturned = clientRepository.findById(id).orElseThrow();

        return convertToClientResponseDTO(clientReturned);
    }

    private ClientResponseDTO convertToClientResponseDTO(Client clientReturned) {
        return new ClientResponseDTO(
                clientReturned.getId(),
                clientReturned.getName(),
                clientReturned.getCpf(),
                clientReturned.getIncome(),
                clientReturned.getBirthDate(),
                clientReturned.getChildren()
        );
    }

}
