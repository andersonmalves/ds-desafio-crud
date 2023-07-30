package com.devsuperior.crud.dto.mapper;

import com.devsuperior.crud.domain.entity.Client;
import com.devsuperior.crud.dto.request.ClientRequest;
import com.devsuperior.crud.dto.response.ClientResponse;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor
public class ClientMapper {

    public static ClientResponse toResponse(final Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .cpf(client.getCpf())
                .income(client.getIncome())
                .birthDate(client.getBirthDate())
                .children(client.getChildren())
                .build();
    }

    public static Client toClient(final ClientRequest request) {
        return Client.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .income(request.getIncome())
                .birthDate(request.getBirthDate())
                .children(request.getChildren())
                .build();
    }
}
