package com.technical.bank.domain.service.cliente;

import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearClienteServiceTest {

    @InjectMocks
    private CrearClienteService service;

    @Mock
    private ClienteOutPutPort clienteOutPutPort;

    @Mock
    private PersonaOuPutPort personaOuPutPort;

    private Cliente cliente1;

    @BeforeEach
    public void setUp(){
        cliente1 = Cliente.builder()
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
    public void shouldCrearClientes(){
        when(personaOuPutPort.guardarPersona(any()))
                .thenReturn(cliente1);

        when(clienteOutPutPort.findByPersonaIdentificacion(anyString()))
                .thenReturn(Optional.empty());

        when(clienteOutPutPort.guardarCliente(any(),any()))
                .thenReturn(cliente1);

        List<Cliente> respuestaCliente = service.crearClientes(Collections.singletonList(cliente1));

        Assertions.assertNotNull(respuestaCliente);
        Assertions.assertEquals(respuestaCliente.get(0),cliente1);
    }

    @Test
    public void shouldCrearClientesException(){
        when(personaOuPutPort.guardarPersona(any()))
                .thenReturn(cliente1);

        when(clienteOutPutPort.findByPersonaIdentificacion(anyString()))
                .thenReturn(Optional.of(cliente1));

        assertThrows(BusinessException.class,() -> service.crearClientes(Collections.singletonList(cliente1)));
    }

}