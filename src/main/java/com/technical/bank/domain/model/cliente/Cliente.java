package com.technical.bank.domain.model.cliente;

import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.persona.Persona;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder(toBuilder = true)
@Getter
public class Cliente extends Persona {

    private final String clienteId;
    private final String contrasena;
    private final String estado;
    private final List<Cuenta> cuentas;
}
