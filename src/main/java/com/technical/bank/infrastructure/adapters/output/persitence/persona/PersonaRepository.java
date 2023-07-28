package com.technical.bank.infrastructure.adapters.output.persitence.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository< PersonaEntity, String> {

    Optional<PersonaEntity> findByNombre(String nombre);
}
