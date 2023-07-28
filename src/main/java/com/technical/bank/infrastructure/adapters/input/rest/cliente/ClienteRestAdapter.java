package com.technical.bank.infrastructure.adapters.input.rest.cliente;

import com.technical.bank.application.ports.input.cliente.CrearClienteUseCase;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.infrastructure.adapters.input.rest.cliente.dto.ClienteDTO;
import com.technical.bank.infrastructure.adapters.input.rest.cliente.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteRestAdapter {

    private final CrearClienteUseCase crearClienteUseCase;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> crearCliente(@Valid @RequestBody List<ClienteDTO> clienteDTOS){
        List<Cliente> clientes = clienteDTOS.stream().map(ClienteMapper::ClienteDtoToCliente).collect(Collectors.toList());

        return crearClienteUseCase.crearCliente(clientes);
    }
}
