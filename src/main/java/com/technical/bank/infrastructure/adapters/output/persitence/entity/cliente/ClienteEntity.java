package com.technical.bank.infrastructure.adapters.output.persitence.entity.cliente;

import com.technical.bank.infrastructure.adapters.output.persitence.entity.cuenta.CuentaEntity;
import com.technical.bank.infrastructure.adapters.output.persitence.entity.persona.PersonaEntity;
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
    private String clienteId;

    @Column
    private String contrasena;

    @Column
    private String estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", referencedColumnName = "identificacion")
    private PersonaEntity personaEntity;

    @OneToMany(mappedBy="clienteEntity")
    private List<CuentaEntity> cuentasEntity;
}
