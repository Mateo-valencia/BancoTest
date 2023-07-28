package com.technical.bank.infrastructure.adapters.config;

import com.technical.bank.domain.service.cliente.CrearClienteService;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClientePersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClienteRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper.ClientePersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.PersonaPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.PersonaRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.mapper.PersonaPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClientePersistenceAdapter clientePersistenceAdapter (
            ClienteRepository clienteRepository,
            ClientePersistenceMapper clientePersistenceMapper
    ){
        return new ClientePersistenceAdapter(clienteRepository,clientePersistenceMapper);
    }

    @Bean
    public PersonaPersistenceAdapter personaPersistenceAdapter(
        PersonaRepository personaRepository,
        PersonaPersistenceMapper personaPersistenceMapper
    ){
        return new PersonaPersistenceAdapter(
                personaRepository,
                personaPersistenceMapper
        );
    }

    @Bean
    public CuentaPersistenceAdapter cuentaPersistenceAdapter (){
        return new CuentaPersistenceAdapter();
    }

    @Bean
    public MovimientoPersistenceAdapter movimientoPersistenceAdapter (){
        return new MovimientoPersistenceAdapter();
    }

    @Bean
    public CrearClienteService crearClienteService(
            ClientePersistenceAdapter clientePersistenceAdapter,
            PersonaPersistenceAdapter personaPersistenceAdapter
    ){
        return  new CrearClienteService(
                clientePersistenceAdapter,
                personaPersistenceAdapter
        );
    }
}
