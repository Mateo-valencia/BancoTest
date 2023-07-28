package com.technical.bank.infrastructure.adapters.input.rest.cliente.mapper;

import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.infrastructure.adapters.input.rest.cliente.dto.ClienteDTO;

public class ClienteMapper {

    private ClienteMapper() {
    }

    public static Cliente ClienteDtoToCliente(ClienteDTO clienteDTO){
        return Cliente.builder()
                .identificacion(clienteDTO.getIdentificacion())
                .nombre(clienteDTO.getNombres())
                .genero(clienteDTO.getGenero())
                .edad(clienteDTO.getEdad())
                .direccion(clienteDTO.getDireccion())
                .telefono(clienteDTO.getTelefono())
                .contrasena(clienteDTO.getContrasena())
                .estado(clienteDTO.getEstado())
                .build();
    }
}
