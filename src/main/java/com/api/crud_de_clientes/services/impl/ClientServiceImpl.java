package com.api.crud_de_clientes.services.impl;

import com.api.crud_de_clientes.dtos.ClientRequestDTO;
import com.api.crud_de_clientes.dtos.ClientResponseDTO;
import com.api.crud_de_clientes.entities.Client;
import com.api.crud_de_clientes.repositories.ClientRepository;
import com.api.crud_de_clientes.services.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        Client newClient = convertToClient(clientRequestDTO);
        Client clientSaved = clientRepository.save(newClient);

        return convertToClientResponseDTO(clientSaved);
    }

    @Transactional(readOnly = true)
    @Override
    public ClientResponseDTO retrieveClientById(Long id) {
        Client clientReturned = clientRepository.findById(id).orElseThrow();

        return convertToClientResponseDTO(clientReturned);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientResponseDTO> listAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return clientList.stream().map(this::convertToClientResponseDTO).toList();
    }

    @Transactional
    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        Client clientReturned = clientRepository.findById(id).orElseThrow();
        updateClientReturned(clientRequestDTO, clientReturned);

        Client clientSaved = clientRepository.save(clientReturned);
        return convertToClientResponseDTO(clientSaved);
    }

    private static void updateClientReturned(ClientRequestDTO clientRequestDTO, Client clientReturned) {
        clientReturned.setName(clientRequestDTO.getName() != null ? clientRequestDTO.getName() : clientReturned.getName());
        clientReturned.setCpf(clientRequestDTO.getCpf() != null ? clientRequestDTO.getCpf() : clientReturned.getCpf());
        clientReturned.setIncome(clientRequestDTO.getIncome() != null ? clientRequestDTO.getIncome() : clientReturned.getIncome());
        clientReturned.setBirthDate(clientRequestDTO.getBirthDate() != null ? clientRequestDTO.getBirthDate() : clientReturned.getBirthDate());
        clientReturned.setChildren(clientRequestDTO.getChildren() != null ? clientRequestDTO.getChildren() : clientReturned.getChildren());
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

    private Client convertToClient(ClientRequestDTO clientRequestDTO) {
        Client newClient = new Client();
        newClient.setName(clientRequestDTO.getName());
        newClient.setCpf(clientRequestDTO.getCpf());
        newClient.setIncome(clientRequestDTO.getIncome());
        newClient.setBirthDate(clientRequestDTO.getBirthDate());
        newClient.setChildren(clientRequestDTO.getChildren());
        return newClient;
    }

}
