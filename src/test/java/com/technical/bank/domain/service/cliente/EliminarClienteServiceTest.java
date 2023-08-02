package com.technical.bank.domain.service.cliente;

import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cuenta.Cuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EliminarClienteServiceTest {

    @InjectMocks
    private EliminarClienteService service;

    @Mock
    private ClienteOutPutPort clienteOutPutPort;

    @Mock
    private PersonaOuPutPort personaOuPutPort;

    @Mock
    private CuentaOutPutPort cuentaOutPutPort;

    private Cliente cliente1;

    @BeforeEach
    public void setUp(){
        cliente1 = Cliente.builder()
                .clienteId("E123E12E")
                .identificacion("0001")
                .nombre("Juan Carlos")
                .genero("Masculino")
                .edad(24)
                .direccion("CRA 14A")
                .telefono("312789648")
                .contrasena("123")
                .estado(true)
                .build();
    }

    @Test
    public void shouldEliminarClientes(){
        when(clienteOutPutPort.findByClienteId(anyString()))
                .thenReturn(Optional.of(cliente1));

        when(cuentaOutPutPort.findByClienteId(anyString()))
                .thenReturn(Collections.emptyList());

        service.elimnarClientes(Collections.singletonList(cliente1));

        verify(personaOuPutPort, times(1)).eliminarPersona(anyString());
        verify(clienteOutPutPort, times(1)).eliminarCliente(anyString());

    }

    @Test
    public void shouldEliminarClientesExceptionIdCliente(){
        Cliente cliente = cliente1.toBuilder().clienteId(null).build();

        assertThrows(BusinessException.class, () -> service.elimnarClientes(Collections.singletonList(cliente)));
    }

    @Test
    public void shouldEliminarClientesExceptionCuentasAsociadas(){
        when(clienteOutPutPort.findByClienteId(anyString()))
                .thenReturn(Optional.of(cliente1));

        when(cuentaOutPutPort.findByClienteId(anyString()))
                .thenReturn(Collections.singletonList(Cuenta.builder().build()));

        assertThrows(BusinessException.class, () -> service.elimnarClientes(Collections.singletonList(
                cliente1)));
    }

    @Test
    public void shouldEliminarClientesExceptionNoExisteCliente(){
        when(clienteOutPutPort.findByClienteId(anyString()))
                .thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> service.elimnarClientes(Collections.singletonList(
                cliente1)));
    }

}