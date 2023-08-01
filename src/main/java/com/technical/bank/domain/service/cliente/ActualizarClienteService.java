package com.technical.bank.domain.service.cliente;

import com.technical.bank.application.ports.input.cliente.ActualizarClienteUseCase;
import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cliente.ClienteFactory;
import com.technical.bank.domain.model.persona.Persona;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ActualizarClienteService implements ActualizarClienteUseCase {

    private final ClienteOutPutPort clienteOutPutPort;
    private final PersonaOuPutPort personaOuPutPort;

    @Override
    public List<Cliente> actualizarClientes(List<Cliente> clientes) {
        return clientes.stream()
                .map(cliente -> {
                    if (cliente.getClienteId() != null){
                        Optional<Cliente> clienteExistente = clienteOutPutPort.findByClienteId(cliente.getClienteId());

                        if (clienteExistente.isPresent()){
                            Cliente clienteActualizado = ClienteFactory.actualizarDatosCliente(clienteExistente.get(),cliente);

                            Persona persona = personaOuPutPort.guardarPersona(clienteActualizado);

                            return clienteOutPutPort.guardarCliente(clienteActualizado,persona);
                        }

                        throw new BusinessException("El Cliente No Existe");
                    }

                    throw new BusinessException("El Id Cliente Es Requerido Para la Actualizacion");
                })
                .collect(Collectors.toList());
    }
}
