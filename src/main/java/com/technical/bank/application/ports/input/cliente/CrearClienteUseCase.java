package com.technical.bank.application.ports.input.cliente;

import com.technical.bank.domain.model.cliente.Cliente;

import java.util.List;

public interface CrearClienteUseCase {

    List<Cliente> crearClientes(List<Cliente> cliente);


}
