package com.technical.bank.domain.service.cuenta;

import com.technical.bank.application.ports.input.cuenta.CrearCuentaUseCase;
import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.persona.Persona;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CrearCuentaService implements CrearCuentaUseCase {

    private final CuentaOutPutPort cuentaOutPutPort;
    private final PersonaOuPutPort personaOuPutPort;
    private final ClienteOutPutPort clienteOutPutPort;

    @Override
    public List<Cuenta> crearCuentas(List<Cuenta> cuentas) {

        for (Cuenta cuenta : cuentas) {
            Optional<Persona> persona = personaOuPutPort.findByNombre(cuenta.getNombreCliente());

            if (persona.isPresent()){
                Optional<Cliente> cliente = clienteOutPutPort.findByPersonaIdentificacion(persona.get().getIdentificacion());

                if (cliente.isPresent()){
                    List<Cuenta> cuentasExistentes = cuentaOutPutPort.findByClienteId(cliente.get().getClienteId());

                    cuentasExistentes.add(cuenta);

                    Cliente clienteActualizado = cliente.get().toBuilder().cuentas(cuentasExistentes).build();
                    clienteOutPutPort.guardarCliente(clienteActualizado,persona.get());
                }
            }
        }

        return cuentas;
    }
}
