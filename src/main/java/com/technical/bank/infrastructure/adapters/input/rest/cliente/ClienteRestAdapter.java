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
import java.util.Objects;

@RestController
@RequestMapping("/prestamo")
@RequiredArgsConstructor
public class ClienteRestAdapter {

    private final CrearClienteUseCase crearClienteUseCase;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String crearCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = crearClienteUseCase.crearCliente(ClienteMapper.ClienteDtoToCliente(clienteDTO));

        return Objects.nonNull(cliente) ? "Creacion del Cliente Exitosa" : "Ocurrio Un error Con la creacion del cliente";
    }
}
