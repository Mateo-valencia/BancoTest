package com.technical.bank.infrastructure.adapters.output.persitence.cuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    @Query(value = "select * from public.tb_cuenta where cliente_id = :clienteId", nativeQuery = true)
    List<CuentaEntity> findByClienteId(@Param("clienteId") String clienteId);
}
