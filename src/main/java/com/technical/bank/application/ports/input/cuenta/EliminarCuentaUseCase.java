package com.technical.bank.application.ports.input.cuenta;

import com.technical.bank.domain.model.cuenta.Cuenta;

import java.util.List;

public interface EliminarCuentaUseCase {

    void eliminarCuentas(List<Cuenta> cuentas);
}
