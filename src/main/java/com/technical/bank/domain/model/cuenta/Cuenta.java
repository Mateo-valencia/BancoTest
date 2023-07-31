package com.technical.bank.domain.model.cuenta;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.technical.bank.domain.model.movimiento.Movimiento;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@EqualsAndHashCode
@Builder(toBuilder = true)
@Getter
public class Cuenta {

    private final int numero;
    private final String tipo;
    private final int saldoInicial;
    private final int saldoDisponible;
    private final boolean estado;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Movimiento> movimientos;
    private final String nombreCliente;
}
