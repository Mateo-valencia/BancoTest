package com.technical.bank.infrastructure.adapters.output.persitence.cuenta;

import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.mapper.CuentaPersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoEntity;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.mapper.MovimientoPersistenceMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CuentaPersistenceAdapter implements CuentaOutPutPort {

    private final CuentaRepository cuentaRepository;
    private final CuentaPersistenceMapper cuentaPersistenceMapper;
    private final MovimientoPersistenceMapper movimientoPersistenceMapper;

    @Override
    public Cuenta guardarCuenta(Cuenta cuenta) {
        CuentaEntity cuentaEntity = cuentaPersistenceMapper.toCuentaEntity(cuenta);

        if (cuenta.getMovimientos() != null && !cuenta.getMovimientos().isEmpty()){
            List<MovimientoEntity> movimientoEntities = cuenta.getMovimientos().stream()
                    .map(movimientoPersistenceMapper::toMovimientoEntity).collect(Collectors.toList());

            cuentaEntity.setMovimientosEntity(movimientoEntities);
        }

        cuentaEntity = cuentaRepository.save(cuentaEntity);

        return cuentaPersistenceMapper.toCuenta(cuentaEntity);
    }

    @Override
    public Optional<Cuenta> findByNumeroCuenta(Integer numeroCuenta) {
        return cuentaRepository.findById(numeroCuenta).map(cuentaPersistenceMapper::toCuenta);
    }

    @Override
    public List<Cuenta> findByClienteId(String ClienteId) {
        return cuentaRepository.findByClienteId(ClienteId).stream()
                .map(cuentaPersistenceMapper::toCuenta).collect(Collectors.toList());
    }

    @Override
    public void eliminarCuenta(Integer numero) {
        cuentaRepository.deleteById(numero);
    }
}
