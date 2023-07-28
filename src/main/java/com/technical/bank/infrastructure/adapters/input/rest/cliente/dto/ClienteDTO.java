package com.technical.bank.infrastructure.adapters.input.rest.cliente.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private String identificacion;
    private String nombres;
    private String genero;
    private int edad;
    private String direccion;
    private String telefono;
    private String contrasena;
    private Boolean estado;
}
