package com.technical.bank.infrastructure.adapters.output.persitence.entity.persona;

import com.technical.bank.infrastructure.adapters.output.persitence.entity.cliente.ClienteEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tb_persona")
public class PersonaEntity {

    @Id
    private String identificacion;

    @Column
    private String nombre;

    @Column
    private String genero;

    @Column
    private int edad;

    @Column
    private String direccion;

    @Column
    private String telefono;

    @OneToOne(mappedBy = "personaEntity")
    private ClienteEntity clienteEntity;
}
