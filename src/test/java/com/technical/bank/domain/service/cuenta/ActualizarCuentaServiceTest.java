package com.technical.bank.domain.service.cuenta;

import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cuenta.Cuenta;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCuentaServiceTest {

    @InjectMocks
    private ActualizarCuentaService service;

    @Mock
    private CuentaOutPutPort cuentaOutPutPort;

    private Cuenta cuenta;

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
    }

    @Test
    public void actualizarCuentas(){
        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.of(cuenta));

        when(cuentaOutPutPort.guardarCuenta(any()))
                .thenReturn(cuenta);

        List<Cuenta> cuentas = service.actualizarCuentas(Collections.singletonList(cuenta));

        Assertions.assertNotNull(cuentas);
        Assertions.assertEquals(cuentas.get(0),cuenta);
    }

    @Test
    public void shouldActualizarCuentasException(){
        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.empty());

        assertThrows(BusinessException.class,() -> service.actualizarCuentas(Collections.singletonList(cuenta)));
    }
}