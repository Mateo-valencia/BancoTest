package com.technical.bank.domain.service.cliente;

import com.technical.bank.application.ports.input.cliente.EliminarClienteUseCase;
import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cuenta.Cuenta;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class EliminarClienteService implements EliminarClienteUseCase {

    private final ClienteOutPutPort clienteOutPutPort;
    private final PersonaOuPutPort personaOuPutPort;
    private final CuentaOutPutPort cuentaOutPutPort;

    @Override
    public void elimnarClientes(List<Cliente> clientes) {

        clientes.forEach(cliente -> {
            if (cliente.getClienteId() != null) {
                Optional<Cliente> clienteExistente = clienteOutPutPort.findByClienteId(cliente.getClienteId());

                if (clienteExistente.isPresent()) {

                    List<Cuenta> cuentasAsociadas = cuentaOutPutPort.findByClienteId(cliente.getClienteId());

                    if (cuentasAsociadas == null || cuentasAsociadas.isEmpty()){
                        personaOuPutPort.eliminarPersona(clienteExistente.get().getIdentificacion());
                        clienteOutPutPort.eliminarCliente(clienteExistente.get().getClienteId());
                    }

                    throw new BusinessException("El cliente Tiene Cuentas Asociadas Inicialmente debe Eliminar Las Cuentas.");
                }

                throw new BusinessException("El Cliente No Existe");
            }

            throw new BusinessException("El Id Cliente Es Requerido Para la Eliminacion");
        });

    }
}
