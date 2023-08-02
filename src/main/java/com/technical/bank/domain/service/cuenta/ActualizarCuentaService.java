package com.technical.bank.domain.service.cuenta;

import com.technical.bank.application.ports.input.cuenta.ActualizarCuentaUseCase;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.cuenta.CuentaFactory;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ActualizarCuentaService implements ActualizarCuentaUseCase {

    private final CuentaOutPutPort cuentaOutPutPort;

    @Override
    public List<Cuenta> actualizarCuentas(List<Cuenta> cuentas) {

        List<Cuenta> cuentasActualizadas = new ArrayList<>();

        for (Cuenta cuenta : cuentas) {
            Optional<Cuenta> cuentaExistente = cuentaOutPutPort.findByNumeroCuenta(cuenta.getNumero());

            if (cuentaExistente.isPresent()){
                Cuenta cuentaActualizada = CuentaFactory.actualizatDatosCuenta(cuentaExistente.get(),cuenta);

                cuentasActualizadas.add(cuentaOutPutPort.guardarCuenta(cuentaActualizada));
            }else {
                throw new BusinessException("El Numero de cuenta No existe");
            }
        }

        return cuentasActualizadas;
    }
}
