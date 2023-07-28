package com.technical.bank.infrastructure.adapters.output.persitence.persona;

import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClienteEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tb_persona")
public class PersonaEntity {

    @Id
    @Column(length = 20)
    private String identificacion;

    @Column(length = 40)
    private String nombre;

    @Column(length = 10)
    private String genero;

    @Column
    private int edad;

    @Column(length = 100)
    private String direccion;

    @Column(length = 30)
    private String telefono;

    @OneToOne(mappedBy = "personaEntity")
    private ClienteEntity clienteEntity;
}
