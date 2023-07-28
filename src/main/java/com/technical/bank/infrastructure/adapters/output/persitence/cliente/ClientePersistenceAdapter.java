package com.technical.bank.infrastructure.adapters.output.persitence.cliente;

import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.persona.Persona;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper.ClientePersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaEntity;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.mapper.CuentaPersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.mapper.PersonaPersistenceMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ClientePersistenceAdapter implements ClienteOutPutPort {

    private final ClienteRepository clienteRepository;
    private final CuentaRepository cuentaRepository;
    private final ClientePersistenceMapper clientePersistenceMapper;
    private final PersonaPersistenceMapper personaPersistenceMapper;
    private final CuentaPersistenceMapper cuentaPersistenceMapper;

    @Override
    public Cliente guardarCliente(Cliente cliente, Persona persona) {
        ClienteEntity clienteEntity = clientePersistenceMapper.toClienteEntity(cliente);
        clienteEntity.setPersonaEntity(personaPersistenceMapper.toPersonaEntity(persona));

        if (cliente.getCuentas() != null){
            ClienteEntity finalClienteEntity = clienteEntity;
            cliente.getCuentas().forEach(cuenta -> {
                CuentaEntity cuentaEntity = cuentaPersistenceMapper.toCuentaEntity(cuenta);
                cuentaEntity.setClienteEntity(finalClienteEntity);
                cuentaRepository.save(cuentaEntity);
            });
        }

        clienteEntity = clienteRepository.save(clienteEntity);

        return clientePersistenceMapper.toCliente(clienteEntity);
    }

    @Override
    public Optional<Cliente> findByPersonaIdentificacion(String identificacion) {
        return clienteRepository.findByPersonaEntityIdentificacion(identificacion)
                .map(clientePersistenceMapper::toCliente);
    }

}
