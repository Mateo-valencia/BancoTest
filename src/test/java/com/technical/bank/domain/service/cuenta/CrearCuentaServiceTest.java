package com.technical.bank.domain.service.cuenta;

import com.technical.bank.application.ports.output.Persona.PersonaOuPutPort;
import com.technical.bank.application.ports.output.cliente.ClienteOutPutPort;
import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cliente.Cliente;
import com.technical.bank.domain.model.cuenta.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearCuentaServiceTest {

    @InjectMocks
    private CrearCuentaService service;

    @Mock
    private CuentaOutPutPort cuentaOutPutPort;

    @Mock
    private ClienteOutPutPort clienteOutPutPort;

    @Mock
    private PersonaOuPutPort personaOuPutPort;

    private Cuenta cuenta;
    private Cliente cliente;

    @BeforeEach
    public void setUp(){
        cuenta = Cuenta.builder()
                .numero(41154)
                .tipo("Ahorros")
                .saldoInicial(1000)
                .saldoDisponible(1000)
                .estado(true)
                .nombreCliente("Juan Carlos")
                .build();

        cliente = Cliente.builder()
                .clienteId("DWDW123")
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
    public void shouldCrearCuentas(){
        when(personaOuPutPort.findByNombre(anyString()))
                .thenReturn(Optional.of(cliente));

        when(clienteOutPutPort.findByPersonaIdentificacion(anyString()))
                .thenReturn(Optional.of(cliente));

        when(cuentaOutPutPort.findByClienteId(anyString()))
                .thenReturn(new ArrayList<>());

        when(clienteOutPutPort.guardarCliente(any(),any()))
                .thenReturn(cliente);

        List<Cuenta> cuentas = service.crearCuentas(Collections.singletonList(cuenta));

        Assertions.assertNotNull(cuentas);
        Assertions.assertEquals(cuentas.get(0),cuenta);
    }

    @Test
    public void shouldCrearCuentasException(){
        when(personaOuPutPort.findByNombre(anyString()))
                .thenReturn(Optional.empty());

        assertThrows(BusinessException.class,() -> service.crearCuentas(Collections.singletonList(cuenta)));
    }
}