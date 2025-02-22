package com.api.crud_de_clientes.services;

import com.api.crud_de_clientes.dtos.ClientResponseDTO;

import java.util.List;

public interface ClientService {

    ClientResponseDTO retrieveClientById(Long id);

    List<ClientResponseDTO> listAllClients();

}
