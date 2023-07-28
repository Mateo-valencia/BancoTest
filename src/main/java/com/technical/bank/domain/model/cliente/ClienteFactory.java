package com.technical.bank.domain.model.cliente;

public class ClienteFactory {

    private ClienteFactory() {
    }

    public static Cliente setClienteId(Cliente cliente, String id){
        return cliente.toBuilder()
                .clienteId( id )
                .build();
    }
}
