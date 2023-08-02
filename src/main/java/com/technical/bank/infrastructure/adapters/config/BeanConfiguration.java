package com.technical.bank.infrastructure.adapters.config;

import com.technical.bank.domain.service.cliente.ActualizarClienteService;
import com.technical.bank.domain.service.cliente.CrearClienteService;
import com.technical.bank.domain.service.cliente.EliminarClienteService;
import com.technical.bank.domain.service.cuenta.ActualizarCuentaService;
import com.technical.bank.domain.service.cuenta.CrearCuentaService;
import com.technical.bank.domain.service.cuenta.EliminarCuentaService;
import com.technical.bank.domain.service.movimiento.ActualizarMovimientoService;
import com.technical.bank.domain.service.movimiento.EliminarMovimientoService;
import com.technical.bank.domain.service.movimiento.RealizarMovimientoService;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClientePersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClienteRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper.ClientePersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.cliente.mapper.ClientePersistenceMapperImpl;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.mapper.CuentaPersistenceMapper;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoRepository;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.mapper.MovimientoPersistenceMapper;
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
            ClientePersistenceMapper clientePersistenceMapper,
            PersonaPersistenceMapper personaPersistenceMapper,
            CuentaPersistenceMapper cuentaPersistenceMapper
    ){
        return new ClientePersistenceAdapter(
                clienteRepository,
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
            CuentaPersistenceMapper cuentaPersistenceMapper,
            MovimientoPersistenceMapper movimientoPersistenceMapper
    ){
        return new CuentaPersistenceAdapter(
                cuentaRepository,
                cuentaPersistenceMapper,
                movimientoPersistenceMapper
        );
    }

    @Bean
    public MovimientoPersistenceAdapter movimientoPersistenceAdapter (
            MovimientoRepository movimientoRepository,
            MovimientoPersistenceMapper movimientoPersistenceMapper
    ){
        return new MovimientoPersistenceAdapter(
                movimientoRepository,
                movimientoPersistenceMapper
        );
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
    public ActualizarClienteService actualizarClienteService(
            ClientePersistenceAdapter clientePersistenceAdapter,
            PersonaPersistenceAdapter personaPersistenceAdapter
    ){
        return  new ActualizarClienteService(
                clientePersistenceAdapter,
                personaPersistenceAdapter
        );
    }

    @Bean
    public EliminarClienteService eliminarClienteService(
            ClientePersistenceAdapter clientePersistenceAdapter,
            PersonaPersistenceAdapter personaPersistenceAdapter,
            CuentaPersistenceAdapter cuentaPersistenceAdapter
    ){
        return new EliminarClienteService(
                clientePersistenceAdapter,
                personaPersistenceAdapter,
                cuentaPersistenceAdapter
        );
    }

    @Bean
    public CrearCuentaService crearCuentaService(
            CuentaPersistenceAdapter cuentaPersistenceAdapter,
            PersonaPersistenceAdapter personaPersistenceAdapter,
            ClientePersistenceAdapter clientePersistenceAdapter
    ){
        return new CrearCuentaService(
                cuentaPersistenceAdapter,
                personaPersistenceAdapter,
                clientePersistenceAdapter
        );
    }

    @Bean
    public ActualizarCuentaService actualizarClienteService(
            CuentaPersistenceAdapter cuentaPersistenceAdapter
    ){
        return new ActualizarCuentaService(cuentaPersistenceAdapter);
    }

    @Bean
    public EliminarCuentaService eliminarCuentaService(
            CuentaPersistenceAdapter cuentaPersistenceAdapter,
            MovimientoPersistenceAdapter movimientoPersistenceAdapter
    ){
        return new EliminarCuentaService(
                cuentaPersistenceAdapter,
                movimientoPersistenceAdapter
        );
    }

    @Bean
    public RealizarMovimientoService realizarMovimientoService(
            MovimientoPersistenceAdapter movimientoPersistenceAdapter,
            CuentaPersistenceAdapter cuentaPersistenceAdapter
    ){
        return new RealizarMovimientoService(
                movimientoPersistenceAdapter,
                cuentaPersistenceAdapter
        );
    }

    @Bean
    public ActualizarMovimientoService actualizarMovimientoService(
            MovimientoPersistenceAdapter movimientoPersistenceAdapter,
            CuentaPersistenceAdapter cuentaPersistenceAdapter,
            RealizarMovimientoService realizarMovimientoService
    ){
        return new ActualizarMovimientoService(
                movimientoPersistenceAdapter,
                cuentaPersistenceAdapter,
                realizarMovimientoService
        );
    }

    @Bean
    public EliminarMovimientoService eliminarMovimientoService(
            MovimientoPersistenceAdapter movimientoPersistenceAdapter
    ){
        return new EliminarMovimientoService(movimientoPersistenceAdapter);
    }
}
