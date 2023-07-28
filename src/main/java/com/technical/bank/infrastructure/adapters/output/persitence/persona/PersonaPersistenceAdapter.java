package com.technical.bank.infrastructure.adapters.output.persitence.persona;

import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.domain.model.persona.Persona;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.mapper.PersonaPersistenceMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonaPersistenceAdapter implements PersonaOuPutPort {

    private final PersonaRepository personaRepository;
    private final PersonaPersistenceMapper personaPersistenceMapper;

    @Override
    public Persona guardarPersona(Persona persona) {
        PersonaEntity personaEntity = personaPersistenceMapper.toPersonaEntity(persona);
        personaEntity = personaRepository.save(personaEntity);
        return personaPersistenceMapper.toPersona(personaEntity);
    }
}
