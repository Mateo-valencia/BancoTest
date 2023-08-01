package com.technical.bank.domain.service.cliente;

import com.technical.bank.application.ports.input.cliente.CrearClienteUseCase;
import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cliente.ClienteFactory;
import com.technical.bank.domain.model.persona.Persona;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CrearClienteService implements CrearClienteUseCase {

    private final ClienteOutPutPort clienteOutPutPort;
    private final PersonaOuPutPort personaOuPutPort;

    @Override
    public List<Cliente> crearClientes(List<Cliente> clientes) {

        return clientes.stream()
                .map(cliente -> {
                    Persona persona = personaOuPutPort.guardarPersona(cliente);
                    Optional<Cliente> clienteExistente = clienteOutPutPort.findByPersonaIdentificacion(persona.getIdentificacion());

                    if (clienteExistente.isEmpty()){
                        cliente = ClienteFactory.setClienteId(cliente, UUID.randomUUID().toString());

                        return clienteOutPutPort.guardarCliente(cliente,persona);
                    }

                    throw new BusinessException("El Cliente Ya Existe");
                })
                .collect(Collectors.toList());

    }
}
