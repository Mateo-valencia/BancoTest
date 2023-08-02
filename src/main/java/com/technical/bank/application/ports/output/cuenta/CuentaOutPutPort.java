package com.technical.bank.application.ports.output.cuenta;

import com.technical.bank.domain.model.cuenta.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaOutPutPort {
    Cuenta guardarCuenta(Cuenta cuenta);

    Optional<Cuenta> findByNumeroCuenta(Integer numeroCuenta);

    List<Cuenta> findByClienteId(String ClienteId);

    void eliminarCuenta(Integer numero);
}
