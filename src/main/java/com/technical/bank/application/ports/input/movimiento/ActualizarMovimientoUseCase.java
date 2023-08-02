package com.technical.bank.application.ports.input.movimiento;

import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;

import java.util.List;

public interface ActualizarMovimientoUseCase {

    List<Movimiento> actualizarMovimientos(List<MovimientoDTO> movimientosDTOS);
}
