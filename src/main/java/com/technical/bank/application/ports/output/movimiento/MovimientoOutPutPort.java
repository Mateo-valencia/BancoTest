package com.technical.bank.application.ports.output.movimiento;

import com.technical.bank.domain.model.movimiento.Movimiento;

public interface MovimientoOutPutPort {

    Movimiento guardarMovimiento(Movimiento movimiento);
}
