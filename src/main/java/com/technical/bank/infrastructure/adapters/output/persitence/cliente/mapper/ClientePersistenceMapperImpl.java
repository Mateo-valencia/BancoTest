package com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper;

import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClienteEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientePersistenceMapperImpl implements ClientePersistenceMapper{

    @Override
    public ClienteEntity toClienteEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setClienteId( cliente.getClienteId() );
        clienteEntity.setContrasena( cliente.getContrasena() );
        clienteEntity.setEstado( cliente.isEstado() );

        return clienteEntity;
    }

    @Override
    public Cliente toCliente(ClienteEntity clienteEntity) {
        return Cliente.builder()
                .clienteId(clienteEntity.getClienteId())
                .contrasena(clienteEntity.getContrasena())
                .estado(clienteEntity.getEstado())
                .identificacion(clienteEntity.getPersonaEntity().getIdentificacion())
                .nombre(clienteEntity.getPersonaEntity().getNombre())
                .genero(clienteEntity.getPersonaEntity().getGenero())
                .edad(clienteEntity.getPersonaEntity().getEdad())
                .direccion(clienteEntity.getPersonaEntity().getDireccion())
                .telefono(clienteEntity.getPersonaEntity().getTelefono())
                .build();
    }
}
