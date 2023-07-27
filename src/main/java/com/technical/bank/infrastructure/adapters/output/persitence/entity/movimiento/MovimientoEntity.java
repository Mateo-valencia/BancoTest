package com.technical.bank.infrastructure.adapters.output.persitence.entity.movimiento;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
}
