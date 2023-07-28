package com.technical.bank.domain.service.cuenta;

import com.technical.bank.application.ports.input.cuenta.CrearCuentaUseCase;
import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.persona.Persona;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CrearCuentaService implements CrearCuentaUseCase {

    private final PersonaOuPutPort personaOuPutPort;
    private final ClienteOutPutPort clienteOutPutPort;

    @Override
    public List<Cuenta> crearCuentas(List<Cuenta> cuentas) {
        return cuentas.stream()
                .map(cuenta -> {
                    Optional<Persona> persona = personaOuPutPort.findByNombre(cuenta.getNombreCliente());

                    if (persona.isPresent()){
                        Optional<Cliente> cliente = clienteOutPutPort.findByPersonaIdentificacion(persona.get().getIdentificacion());

                        if (!cliente.isEmpty()){
                            List<Cuenta> cuentasExistentes = cliente.get().getCuentas() == null ? new ArrayList<>() : cliente.get().getCuentas();

                            cuentasExistentes.add(cuenta);

                            Cliente clienteActualizado = cliente.get().toBuilder().cuentas(cuentasExistentes).build();
                            clienteOutPutPort.guardarCliente(clienteActualizado,persona.get());

                            return cuenta;
                        }

                        throw new BusinessException("Cliente Asociado a la cuenta No fue encontrado.");
                    }

                    throw new BusinessException("Cliente Asociado a la cuenta No fue encontrado.");
                })
                .collect(Collectors.toList());
    }
}
