package com.devsuperior.crud.controller;

import com.devsuperior.crud.dto.mapper.ClientMapper;
import com.devsuperior.crud.dto.request.ClientRequest;
import com.devsuperior.crud.dto.response.ClientResponse;
import com.devsuperior.crud.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @PostMapping
    public ClientResponse createClient(@RequestBody final ClientRequest request) {
        return ClientMapper.toResponse(clientService.createClient(request));
    }

    @PutMapping("/{id}")
    public ClientResponse updateClient(
            @PathVariable final Long id,
            @RequestBody final ClientRequest request
    ) {
        return ClientMapper.toResponse(clientService.updateClient(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable final Long id) {
        clientService.deleteClientById(id);
    }

}
