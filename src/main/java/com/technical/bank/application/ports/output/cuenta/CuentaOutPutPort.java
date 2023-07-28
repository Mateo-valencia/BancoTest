package com.technical.bank.application.ports.output.cuenta;

import com.technical.bank.domain.model.cuenta.Cuenta;

public interface CuentaOutPutPort {
    Cuenta guardarCuenta(Cuenta cuenta);
}
