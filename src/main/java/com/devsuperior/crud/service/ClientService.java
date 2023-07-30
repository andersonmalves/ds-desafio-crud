package com.devsuperior.crud.service;

import com.devsuperior.crud.domain.entity.Client;
import com.devsuperior.crud.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client getClientById(final Long id) {
        return clientRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
