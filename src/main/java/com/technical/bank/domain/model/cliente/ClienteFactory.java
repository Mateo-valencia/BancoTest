package com.technical.bank.domain.model.cliente;

public class ClienteFactory {

    private ClienteFactory() {
    }

    public static Cliente setClienteId(Cliente cliente, String id){
        return cliente.toBuilder()
                .clienteId( id )
                .build();
    }

    public static Cliente actualizarDatosCliente(Cliente clienteAnterior, Cliente clienteNuevo){
        return clienteAnterior.toBuilder()
                .identificacion(clienteNuevo.getIdentificacion())
                .nombre(clienteNuevo.getNombre())
                .genero(clienteNuevo.getGenero())
                .edad(clienteNuevo.getEdad())
                .direccion(clienteNuevo.getDireccion())
                .telefono(clienteNuevo.getTelefono())
                .contrasena(clienteNuevo.getContrasena())
                .estado(clienteNuevo.isEstado())
                .build();
    }
}
