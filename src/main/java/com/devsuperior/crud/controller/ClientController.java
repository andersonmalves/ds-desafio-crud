package com.devsuperior.crud.controller;

import com.devsuperior.crud.dto.mapper.ClientMapper;
import com.devsuperior.crud.dto.response.ClientResponse;
import com.devsuperior.crud.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    public ClientResponse getClientById(@PathVariable final Long id) {
        return ClientMapper.toResponse(clientService.getClientById(id));
    }
}
