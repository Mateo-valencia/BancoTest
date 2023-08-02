package com.technical.bank.domain.service.cuenta;

import com.technical.bank.application.ports.input.cuenta.EliminarCuentaUseCase;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.movimiento.Movimiento;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class EliminarCuentaService implements EliminarCuentaUseCase {

    private final CuentaOutPutPort cuentaOutPutPort;
    private final MovimientoOutPutPort movimientoOutPutPort;

    @Override
    public void eliminarCuentas(List<Cuenta> cuentas) {
        for (Cuenta cuenta : cuentas) {
            Optional<Cuenta> cuentaExistente = cuentaOutPutPort.findByNumeroCuenta(cuenta.getNumero());

            if (cuentaExistente.isPresent()){
                List<Movimiento> movimientosAsociados = movimientoOutPutPort.findByNumeroCuenta(cuenta.getNumero());

                if (movimientosAsociados == null || movimientosAsociados.isEmpty()){
                    cuentaOutPutPort.eliminarCuenta(cuenta.getNumero());
                }

                throw new BusinessException("No es posible eliminar la cuenta dado que cuenta con movimientos asociados");
            }

            throw new BusinessException("El Numero de cuenta No existe");
        }
    }
}
