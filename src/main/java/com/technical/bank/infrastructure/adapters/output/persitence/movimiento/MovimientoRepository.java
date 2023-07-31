package com.technical.bank.infrastructure.adapters.output.persitence.movimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, String> {

    @Query(value = "select movimiento.fecha, persona.nombre cliente , cuenta.numero numeroCuenta, cuenta.tipo , cuenta.saldo_inicial saldoInicial, \n" +
            "cuenta.estado,movimiento.tipo tipoMovimiento, movimiento.valor movimiento, cuenta.saldo_disponible saldoDisponible\n" +
            "from public.tb_cuenta cuenta\n" +
            "inner join tb_movimiento movimiento on (cuenta.numero = movimiento.numero)\n" +
            "inner join tb_cliente cliente on (cuenta.cliente_id = cliente.cliente_id)\n" +
            "inner join tb_persona persona on (cliente.identificacion = persona.identificacion)\n" +
            "where persona.nombre = 'Marianela Montalvo'\n" +
            "order by movimiento.fecha DESC;", nativeQuery = true)
    List<MovimientoCliente> getMovimientoCliente(@Param("nombreCliente") String nombreCliente);
}
