package com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class MovimientoDTO {

    private int numeroCuenta;
    @Size(max = 15,message = "El campo Tipo Supera el Tamaño Maximo (15)")
    private String tipo;
    @Size(max = 50,message = "El campo SaldoInicial Supera el Tamaño Maximo (50)")
    private int saldoInicial;
    @Size(max = 15,message = "El campo Estado Supera el Tamaño Maximo (15)")
    private boolean estado;
    @Size(max = 20,message = "El campo movimiento Supera el Tamaño Maximo (20)")
    private int movimiento;
}
