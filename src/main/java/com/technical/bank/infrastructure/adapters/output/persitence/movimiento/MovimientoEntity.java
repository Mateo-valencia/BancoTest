package com.technical.bank.infrastructure.adapters.output.persitence.movimiento;

import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "tb_movimiento")
public class MovimientoEntity {

    @Id
    private String id;

    @Column
    private Date fecha;

    @Column
    private String tipo;

    @Column
    private String valor;

    @Column
    private String saldo;

    @ManyToOne
    @JoinColumn(name="numero", nullable=false)
    private CuentaEntity cuentaEntity;
}
