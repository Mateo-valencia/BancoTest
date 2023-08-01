package com.technical.bank.application.ports.input.cliente;

import com.technical.bank.domain.model.cliente.Cliente;

import java.util.List;

public interface ActualizarClienteUseCase {

    List<Cliente> actualizarClientes(List<Cliente> clientes);
}
