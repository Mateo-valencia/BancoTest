package com.technical.bank.domain.model.cliente;

import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.persona.Persona;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class Cliente extends Persona {

    private final String clienteId;
    private final String contrasena;
    private final String estado;
    private final List<Cuenta> cuentas;

    @Builder
    public Cliente(String identificacion, String nombre, String genero, int edad, String direccion, String telefono,
                   String clienteId, String contrasena,String estado,List<Cuenta> cuentas) {
        super(identificacion, nombre, genero, edad, direccion, telefono);
        this.clienteId = clienteId;
        this.contrasena = contrasena;
        this.estado = estado;
        this.cuentas = cuentas;
    }
}
