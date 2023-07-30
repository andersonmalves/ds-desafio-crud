package com.devsuperior.crud.service;

import com.devsuperior.crud.domain.entity.Client;
import com.devsuperior.crud.dto.mapper.ClientMapper;
import com.devsuperior.crud.dto.request.ClientRequest;
import com.devsuperior.crud.dto.response.ClientResponse;
import com.devsuperior.crud.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientResponse> getAllClients(PageRequest pageRequest) {
        // clientRepository.findAll(pageRequest).map(ClientMapper::toResponse);
        // return clientService.getAllClients(pageRequest).stream().map(it -> ClientMapper.toResponse(it)).collect(Collectors.toList());
        return clientRepository.findAll(pageRequest).stream().map(ClientMapper::toResponse).collect(Collectors.toList());
    }

    public Client getClientById(final Long id) {
        return clientRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Client createClient(final ClientRequest request) {
        return clientRepository.save(ClientMapper.toClient(request));
    }

    public Client updateClient(final Long id, final ClientRequest request) {
        final var client = clientRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        client.setName(request.getName());
        client.setCpf(request.getCpf());
        client.setBirthDate(request.getBirthDate());
        client.setIncome(request.getIncome());
        client.setChildren(request.getChildren());

        return clientRepository.save(client);
    }

    public void deleteClientById(final Long id) {
        //TODO: tratar erro caso não exista client
        clientRepository.deleteById(id);
    }
}
