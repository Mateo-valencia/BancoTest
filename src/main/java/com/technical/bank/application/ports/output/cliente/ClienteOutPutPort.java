package com.technical.bank.application.ports.output.cliente;

import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.persona.Persona;

import java.util.Optional;

public interface ClienteOutPutPort {

    Cliente guardarCliente(Cliente cliente, Persona identificacion);

    Optional<Cliente> findByPersonaIdentificacion(String identificacion);
}
