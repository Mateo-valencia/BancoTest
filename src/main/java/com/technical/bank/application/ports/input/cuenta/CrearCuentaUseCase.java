package com.technical.bank.application.ports.input.cuenta;

import com.technical.bank.domain.model.cuenta.Cuenta;

import java.util.List;

public interface CrearCuentaUseCase {

    List<Cuenta> crearCuentas(List<Cuenta> cuentas);
}
