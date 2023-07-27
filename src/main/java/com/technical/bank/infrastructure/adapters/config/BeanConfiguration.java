package com.technical.bank.infrastructure.adapters.config;

import com.technical.bank.infrastructure.adapters.output.persitence.cliente.ClientePersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.cuenta.CuentaPersistenceAdapter;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ClientePersistenceAdapter clientePersistenceAdapter (){
        return new ClientePersistenceAdapter();
    }

    @Bean
    public CuentaPersistenceAdapter cuentaPersistenceAdapter (){
        return new CuentaPersistenceAdapter();
    }

    @Bean
    public MovimientoPersistenceAdapter movimientoPersistenceAdapter (){
        return new MovimientoPersistenceAdapter();
    }
}
