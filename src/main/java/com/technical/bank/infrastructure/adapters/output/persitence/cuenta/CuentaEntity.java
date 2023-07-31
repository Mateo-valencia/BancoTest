package com.technical.bank.infrastructure.adapters.output.persitence.cuenta;

import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoEntity;
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
    private int saldoInicial;

    @Column
    private int saldoDisponible;

    @Column
    private Boolean estado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "numero")
    private List<MovimientoEntity> movimientosEntity;
}
