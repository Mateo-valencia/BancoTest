package com.technical.bank.infrastructure.adapters.output.persitence.cuenta;

import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.mapper.CuentaPersistenceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CuentaPersistenceAdapter implements CuentaOutPutPort {

    private final CuentaRepository cuentaRepository;
    private final CuentaPersistenceMapper cuentaPersistenceMapper;

    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        CuentaEntity cuentaEntity = cuentaPersistenceMapper.toCuentaEntity(cuenta);

        cuentaEntity = cuentaRepository.save(cuentaEntity);

        return cuentaPersistenceMapper.toCuenta(cuentaEntity);
    }
}
