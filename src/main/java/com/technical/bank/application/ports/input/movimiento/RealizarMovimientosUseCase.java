package com.technical.bank.application.ports.input.movimiento;

import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoCliente;

import java.util.List;

public interface RealizarMovimientosUseCase {

    List<Movimiento> realizarMovimientos(List<MovimientoDTO> movimientoDTOS);

    List<MovimientoCliente> getMovimientosCliente(String nombreCliente);
}
