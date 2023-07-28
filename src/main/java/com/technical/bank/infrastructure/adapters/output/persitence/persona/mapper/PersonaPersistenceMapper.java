package com.technical.bank.infrastructure.adapters.output.persitence.persona.mapper;

import com.technical.bank.domain.model.persona.Persona;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.PersonaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaPersistenceMapper {

    Persona toPersona(PersonaEntity personaEntity);
    PersonaEntity toPersonaEntity(Persona persona);
}
