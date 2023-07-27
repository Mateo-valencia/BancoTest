package com.technical.bank.domain.model.movimiento;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@EqualsAndHashCode
@Builder(toBuilder = true)
@Getter
public class Movimiento {

    private final String id;
    private final Date fecha;
    private final String tipo;
    private final String valor;
    private final String saldo;
}
