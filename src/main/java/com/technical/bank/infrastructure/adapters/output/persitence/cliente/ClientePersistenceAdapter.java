package com.technical.bank.infrastructure.adapters.output.persitence.cliente;

import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper.ClientePersistenceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientePersistenceAdapter implements ClienteOutPutPort {

    private final ClienteRepository clienteRepository;
    private final ClientePersistenceMapper clientePersistenceMapper;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clientePersistenceMapper.toClienteEntity(cliente);
        clienteEntity = clienteRepository.save(clienteEntity);

        return clientePersistenceMapper.toCliente(clienteEntity);
    }
}
