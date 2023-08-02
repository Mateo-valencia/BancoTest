package com.technical.bank.domain.service.movimiento;

import com.technical.bank.application.ports.input.movimiento.RealizarMovimientosUseCase;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.mapper.MovimientoMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoCliente;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RealizarMovimientoService implements RealizarMovimientosUseCase {

    private final MovimientoOutPutPort movimientoOutPutPort;
    private final CuentaOutPutPort cuentaOutPutPort;

    private final static String RETIRO = "Retiro";

    @Override
    public List<Movimiento> realizarMovimientos(List<MovimientoDTO> movimientoDTOS) {
        return movimientoDTOS.stream()
                .map(movimientoDTO -> {
                    Movimiento movimiento = MovimientoMapper.crearMovimiento(movimientoDTO);

                    Optional<Cuenta> cuenta = cuentaOutPutPort.findByNumeroCuenta(movimientoDTO.getNumeroCuenta());

                    if (cuenta.isPresent()){
                        Cuenta cuentaActualizada = realizarOperacion(movimiento, cuenta.get());

                        movimiento = movimiento.toBuilder().saldo(cuentaActualizada.getSaldoDisponible()).build();

                        List<Movimiento> movimientosExistentes = cuentaActualizada.getMovimientos() != null ? cuentaActualizada.getMovimientos() : new ArrayList<>();
                        movimientosExistentes.add(movimiento);

                        cuentaActualizada = cuentaActualizada.toBuilder()
                                .movimientos(movimientosExistentes)
                                .build();

                        cuentaOutPutPort.guardarCuenta(cuentaActualizada);
                        return movimientoOutPutPort.guardarMovimiento(movimiento);
                    }else {
                        throw new BusinessException("Cuenta No encontrada");
                    }
                })
                .collect(Collectors.toList());
    }

    public Cuenta realizarOperacion(Movimiento movimiento, Cuenta cuenta) {
        Cuenta cuentaActualizada;

        if (RETIRO.equalsIgnoreCase(movimiento.getTipo())){
            if(cuenta.getSaldoDisponible() == 0){
                throw new BusinessException("Saldo No disponible");
            }

            cuentaActualizada = cuenta.toBuilder()
                    .saldoDisponible(cuenta.getSaldoInicial() - movimiento.getValor())
                    .build();

        }else {
            cuentaActualizada = cuenta.toBuilder()
                    .saldoDisponible(cuenta.getSaldoInicial() + movimiento.getValor())
                    .build();

        }
        return cuentaActualizada;
    }

    @Override
    public List<MovimientoCliente> getMovimientosCliente(String nombreCliente) {
        return movimientoOutPutPort.getMovimientosCliente(nombreCliente);
    }
}
