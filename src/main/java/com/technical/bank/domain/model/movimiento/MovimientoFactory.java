package com.technical.bank.domain.model.movimiento;

import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;

public class MovimientoFactory {

    private MovimientoFactory() {
    }

    public static Movimiento actualizarMovimiento(MovimientoDTO movimientoDTO,Movimiento movimiento){
        return movimiento.toBuilder()
                .fecha(movimientoDTO.getFecha())
                .tipo(movimientoDTO.getTipo())
                .valor(movimientoDTO.getMovimiento())
                .build();
    }
}
