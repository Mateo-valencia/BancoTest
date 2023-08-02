package com.technical.bank.application.ports.output.movimiento;

import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoCliente;

import java.util.List;
import java.util.Optional;

public interface MovimientoOutPutPort {

    Movimiento guardarMovimiento(Movimiento movimiento);

    List<MovimientoCliente> getMovimientosCliente(String nombreCliente);

    List<Movimiento> findByNumeroCuenta(Integer numeroCuenta);

    Optional<Movimiento> findById(String id);

    void eliminarMovimiento(String id);
}
