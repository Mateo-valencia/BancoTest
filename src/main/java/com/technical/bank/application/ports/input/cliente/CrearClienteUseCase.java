package com.technical.bank.application.ports.input.cliente;

import com.technical.bank.domain.model.cliente.Cliente;

public interface CrearClienteUseCase {

    public Cliente crearCliente(Cliente cliente);
}
