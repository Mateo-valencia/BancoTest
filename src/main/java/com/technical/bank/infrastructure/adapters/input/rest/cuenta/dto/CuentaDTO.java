package com.technical.bank.infrastructure.adapters.input.rest.cuenta.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class CuentaDTO {

    private int numeroCuenta;
    @Size(max = 15,message = "El campo Tipo Supera el Tamaño Maximo (15)")
    private String tipo;
    @Size(max = 50,message = "El campo SaldoInicial Supera el Tamaño Maximo (50)")
    private String saldoInicial;
    @Size(max = 15,message = "El campo Estado Supera el Tamaño Maximo (15)")
    private boolean estado;
    @Size(max = 10,message = "El campo Cliente Supera el Tamaño Maximo (10)")
    private String cliente;
}
