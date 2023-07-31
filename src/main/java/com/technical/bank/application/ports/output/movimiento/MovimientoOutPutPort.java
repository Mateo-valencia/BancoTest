package com.technical.bank.application.ports.output.movimiento;

import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoCliente;

import java.util.List;

public interface MovimientoOutPutPort {

    Movimiento guardarMovimiento(Movimiento movimiento);

    List<MovimientoCliente> getMovimientosCliente(String nombreCliente);
}
