package com.technical.bank.infrastructure.adapters.output.persitence.entity.cuenta;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
