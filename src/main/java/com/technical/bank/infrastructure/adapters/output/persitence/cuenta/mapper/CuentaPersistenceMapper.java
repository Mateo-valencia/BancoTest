package com.technical.bank.infrastructure.adapters.output.persitence.cuenta.mapper;

import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CuentaPersistenceMapper {

    CuentaEntity toCuentaEntity(Cuenta cuenta);

    Cuenta toCuenta(CuentaEntity cuentaEntity);
}
