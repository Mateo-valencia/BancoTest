package com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper;


import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClienteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientePersistenceMapper {

    ClienteEntity toClienteEntity(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);
}
