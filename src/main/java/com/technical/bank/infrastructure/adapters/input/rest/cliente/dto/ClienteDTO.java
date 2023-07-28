package com.technical.bank.infrastructure.adapters.input.rest.cliente.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ClienteDTO {

    @Size(max = 20,message = "El campo Identificacion Supera el Tamaño Maximo (50)")
    private String identificacion;
    @Size(max = 40,message = "El campo Nombres Supera el Tamaño Maximo (40)")
    private String nombres;
    @Size(max = 10,message = "El campo Genero Supera el Tamaño Maximo (10)")
    private String genero;
    private int edad;
    @Size(max = 100,message = "El campo Direccion Supera el Tamaño Maximo (100)")
    private String direccion;
    @Size(max = 30,message = "El campo Telefono Supera el Tamaño Maximo (30)")
    private String telefono;
    @Size(max = 10,message = "El campo Contrasena Supera el Tamaño Maximo (10)")
    private String contrasena;
    private Boolean estado;
}
