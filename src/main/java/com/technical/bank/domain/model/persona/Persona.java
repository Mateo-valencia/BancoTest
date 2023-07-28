package com.technical.bank.domain.model.persona;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class Persona {

    protected final String identificacion;
    protected final String nombre;
    protected final String genero;
    protected final int edad;
    protected final String direccion;
    protected final String telefono;
}
