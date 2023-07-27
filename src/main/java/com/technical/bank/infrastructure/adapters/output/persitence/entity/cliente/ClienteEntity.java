package com.technical.bank.infrastructure.adapters.output.persitence.entity.cliente;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "tb_cliente")
public class ClienteEntity  {

    @Id
    private String clienteId;

    @Column
    private String contrasena;

    @Column
    private String estado;

}
