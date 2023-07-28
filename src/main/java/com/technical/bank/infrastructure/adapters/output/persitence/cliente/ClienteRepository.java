package com.technical.bank.infrastructure.adapters.output.persitence.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    Optional<ClienteEntity> findByPersonaEntityIdentificacion(String identificacion);
}
