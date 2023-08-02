package com.technical.bank.infrastructure.adapters.output.persitence.movimiento;

import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.mapper.MovimientoPersistenceMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovimientoPersistenceAdapter implements MovimientoOutPutPort {

    private final MovimientoRepository movimientoRepository;
    private final MovimientoPersistenceMapper movimientoPersistenceMapper;

    @Override
    public Movimiento guardarMovimiento(Movimiento movimiento) {
        MovimientoEntity movimientoEntity = movimientoPersistenceMapper.toMovimientoEntity(movimiento);
        movimientoEntity = movimientoRepository.save(movimientoEntity);
        return movimientoPersistenceMapper.toMovimiento(movimientoEntity);
    }

    @Override
    public List<MovimientoCliente> getMovimientosCliente(String nombreCliente) {
        return movimientoRepository.getMovimientoCliente(nombreCliente);
    }

    @Override
    public List<Movimiento> findByNumeroCuenta(Integer numeroCuenta) {
        return movimientoRepository.findByNumeroCuenta(numeroCuenta)
                .stream()
                .map(movimientoPersistenceMapper::toMovimiento)
                .collect(Collectors.toList());
    }
}
