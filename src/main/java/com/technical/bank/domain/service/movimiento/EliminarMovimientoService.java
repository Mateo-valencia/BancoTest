package com.technical.bank.domain.service.movimiento;

import com.technical.bank.application.ports.input.movimiento.EliminarMovimientoUseCase;
import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EliminarMovimientoService implements EliminarMovimientoUseCase {

    private final MovimientoOutPutPort movimientoOutPutPort;

    @Override
    public void elimnarMovimientos(List<String> ids) {
        ids.forEach(movimientoOutPutPort::eliminarMovimiento);
    }
}
