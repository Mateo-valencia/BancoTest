package com.technical.bank.domain.service.movimiento;

import com.technical.bank.application.ports.input.movimiento.ActualizarMovimientoUseCase;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.domain.model.movimiento.MovimientoFactory;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ActualizarMovimientoService implements ActualizarMovimientoUseCase {

    private final MovimientoOutPutPort movimientoOutPutPort;
    private final CuentaOutPutPort cuentaOutPutPort;
    private final RealizarMovimientoService realizarMovimientoService;

    @Override
    public List<Movimiento> actualizarMovimientos(List<MovimientoDTO> movimientosDTOS) {
        return movimientosDTOS.stream()
                .map(movimientoDTO -> {
                    Optional<Movimiento> movimiento = movimientoOutPutPort.findById(movimientoDTO.getId());

                    if (movimiento.isPresent()){
                        Movimiento movimientoActualizado = MovimientoFactory.actualizarMovimiento(movimientoDTO,movimiento.get());

                        Optional<Cuenta> cuentaAsociada = cuentaOutPutPort.findByNumeroCuenta(movimientoDTO.getNumeroCuenta());

                        if (cuentaAsociada.isPresent()) {
                            Cuenta cuentaActualizada = realizarMovimientoService.realizarOperacion(movimientoActualizado, cuentaAsociada.get());

                            movimientoActualizado = movimientoActualizado.toBuilder().saldo(cuentaActualizada.getSaldoDisponible()).build();

                            cuentaOutPutPort.guardarCuenta(cuentaActualizada);
                            return movimientoOutPutPort.guardarMovimiento(movimientoActualizado);
                        }else {
                            throw new BusinessException("Cuenta Asociada No Encontrada");
                        }

                    }else {
                        throw new BusinessException("Movimiento No encontrado");
                    }
                }).collect(Collectors.toList());
    }
}
