package com.technical.bank.infrastructure.adapters.output.persitence.movimiento.mapper;

import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoPersistenceMapper {

    MovimientoEntity toMovimientoEntity(Movimiento movimiento);

    Movimiento toMovimiento(MovimientoEntity movimientoEntity);
}
