package com.technical.bank.infrastructure.adapters.output.persitence.entity.cuenta;

import com.technical.bank.infrastructure.adapters.output.persitence.entity.cliente.ClienteEntity;
import com.technical.bank.infrastructure.adapters.output.persitence.entity.movimiento.MovimientoEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_cuenta")
public class CuentaEntity {

    @Id
    private int numero;

    @Column
    private String tipo;

    @Column
    private String saldoInicial;

    @Column
    private String estado;

    @ManyToOne
    @JoinColumn(name="clienteId", nullable=false)
    private ClienteEntity clienteEntity;

    @OneToMany(mappedBy="cuentaEntity")
    private List<MovimientoEntity> movimientosEntity;
}
