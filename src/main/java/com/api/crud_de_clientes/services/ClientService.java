package com.api.crud_de_clientes.services;

import com.api.crud_de_clientes.dtos.ClientResponseDTO;

public interface ClientService {

    ClientResponseDTO retrieveClientById(Long id);

}
