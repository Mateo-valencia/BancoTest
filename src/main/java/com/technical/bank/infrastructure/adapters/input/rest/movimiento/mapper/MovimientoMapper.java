package com.technical.bank.infrastructure.adapters.input.rest.movimiento.mapper;

import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;

import java.util.Date;
import java.util.UUID;

public class MovimientoMapper {

    private MovimientoMapper() {
    }

    public static Movimiento crearMovimiento(MovimientoDTO movimientoDTO){
        return Movimiento.builder()
                .id(UUID.randomUUID().toString())
                .fecha(new Date())
                .tipo(movimientoDTO.getTipo())
                .valor(movimientoDTO.getMovimiento())
                .build();
    }
}
