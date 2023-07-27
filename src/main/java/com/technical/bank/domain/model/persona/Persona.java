package com.technical.bank.domain.model.persona;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Builder(toBuilder = true)
@Getter
public class Persona {

    private final String identificacion;
    private final String nombre;
    private final String genero;
    private final int edad;
    private final String direccion;
    private final String telefono;
}
