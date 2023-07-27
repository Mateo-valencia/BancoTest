package com.technical.bank.infrastructure.adapters.output.persitence.movimiento.mapper;

import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface MovimientoPersistenceAdapter {

    MovimientoEntity toMovimientoEntity(Movimiento movimiento);

    Movimiento toMovimiento(MovimientoEntity movimientoEntity);
}
