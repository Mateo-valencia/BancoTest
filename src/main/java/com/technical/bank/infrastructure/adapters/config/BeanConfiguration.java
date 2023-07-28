package com.technical.bank.infrastructure.adapters.config;

import com.technical.bank.domain.service.cliente.CrearClienteService;
import com.technical.bank.domain.service.cuenta.CrearCuentaService;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClientePersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClienteRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper.ClientePersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper.ClientePersistenceMapperImpl;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.mapper.CuentaPersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.PersonaPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.PersonaRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.persona.mapper.PersonaPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClientePersistenceMapperImpl clientePersistenceMapper(){
        return new ClientePersistenceMapperImpl();
    }

    @Bean
    public ClientePersistenceAdapter clientePersistenceAdapter (
            ClienteRepository clienteRepository,
            CuentaRepository cuentaRepository,
            ClientePersistenceMapper clientePersistenceMapper,
            PersonaPersistenceMapper personaPersistenceMapper,
            CuentaPersistenceMapper cuentaPersistenceMapper
    ){
        return new ClientePersistenceAdapter(
                clienteRepository,
                cuentaRepository,
                clientePersistenceMapper,
                personaPersistenceMapper,
                cuentaPersistenceMapper
        );
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
    public CuentaPersistenceAdapter cuentaPersistenceAdapter (
            CuentaRepository cuentaRepository,
            CuentaPersistenceMapper cuentaPersistenceMapper
    ){
        return new CuentaPersistenceAdapter(
                cuentaRepository,
                cuentaPersistenceMapper
        );
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

    @Bean
    public CrearCuentaService crearCuentaService(
            PersonaPersistenceAdapter personaPersistenceAdapter,
            ClientePersistenceAdapter clientePersistenceAdapter
    ){
        return new CrearCuentaService(
                personaPersistenceAdapter,
                clientePersistenceAdapter
        );
    }
}
