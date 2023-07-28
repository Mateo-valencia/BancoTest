package com.technical.bank.domain.service.cliente;

import com.technical.bank.application.ports.input.cliente.CrearClienteUseCase;
import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cliente.ClienteFactory;
import com.technical.bank.domain.model.persona.Persona;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
public class CrearClienteService implements CrearClienteUseCase {

    private final ClienteOutPutPort clienteOutPutPort;
    private final PersonaOuPutPort personaOuPutPort;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Persona persona = personaOuPutPort.guardarPersona(cliente);

        if (Objects.nonNull(persona)){
            cliente = ClienteFactory.setClienteId(cliente, UUID.randomUUID().toString());

            return clienteOutPutPort.guardarCliente(cliente);
        }

        throw new BusinessException("Ocurrio Un error con El registro");
    }
}
