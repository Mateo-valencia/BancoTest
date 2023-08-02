package com.technical.bank.domain.model.cuenta;

public class CuentaFactory {

    private CuentaFactory() {
    }

    public static Cuenta actualizatDatosCuenta(Cuenta cuentaAntigua, Cuenta cuentaNueva){
        return cuentaAntigua.toBuilder()
                .tipo(cuentaNueva.getTipo())
                .saldoInicial(cuentaNueva.getSaldoInicial())
                .saldoDisponible(cuentaNueva.getSaldoInicial())
                .estado(cuentaNueva.isEstado())
                .build();
    }
}
