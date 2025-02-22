package com.api.crud_de_clientes.services;

import com.api.crud_de_clientes.dtos.ClientRequestDTO;
import com.api.crud_de_clientes.dtos.ClientResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    ClientResponseDTO retrieveClientById(Long id);

    Page<ClientResponseDTO> listAllClients(Pageable pageable);

    ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);

    void deleteClient(Long id);

}
