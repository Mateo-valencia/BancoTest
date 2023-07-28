package com.technical.bank.application.ports.output.Persona;

import com.technical.bank.domain.model.persona.Persona;

import java.util.Optional;

public interface PersonaOuPutPort {

    Persona guardarPersona(Persona persona);

    Optional<Persona> findByNombre(String nombre);
}
