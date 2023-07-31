package com.technical.bank.infrastructure.adapters.output.persitence.cliente;

import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaEntity;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.PersonaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tb_cliente")
public class ClienteEntity  {

    @Id
    @Column(length = 50)
    private String clienteId;

    @Column(length = 10)
    private String contrasena;

    @Column
    private Boolean estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identificacion", referencedColumnName = "identificacion")
    private PersonaEntity personaEntity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<CuentaEntity> cuentasEntity;
}
