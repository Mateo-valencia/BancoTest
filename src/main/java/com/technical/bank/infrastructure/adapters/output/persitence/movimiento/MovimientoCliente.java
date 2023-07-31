package com.technical.bank.infrastructure.adapters.output.persitence.movimiento;

public interface MovimientoCliente {

    String getFecha();

    String getCliente();

    String getNumeroCuenta();

    String getTipo();

    Integer getSaldoInicial();

    Boolean getEstado();

    String getTipoMovimiento();

    Integer getMovimiento() ;

    Integer getSaldoDisponible();
}
