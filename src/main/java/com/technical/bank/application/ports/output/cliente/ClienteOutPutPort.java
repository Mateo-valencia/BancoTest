package com.technical.bank.application.ports.output.cliente;

import com.technical.bank.domain.model.cliente.Cliente;

public interface ClienteOutPutPort {

    Cliente guardarCliente(Cliente cliente);
}
