package com.technical.bank.domain.service.cuenta;

import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.movimiento.Movimiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EliminarCuentaServiceTest {

    @InjectMocks
    private EliminarCuentaService service;

    @Mock
    private CuentaOutPutPort cuentaOutPutPort;

    @Mock
    private MovimientoOutPutPort movimientoOutPutPort;

    private Cuenta cuenta;

    @BeforeEach
    public void setUp(){
        cuenta = Cuenta.builder()
                .numero(41154)
                .build();
    }

    @Test
    public void shouldEliminarCuentas(){
        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.of(cuenta));

        when(movimientoOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(new ArrayList<>());

        service.eliminarCuentas(Collections.singletonList(cuenta));

        verify(cuentaOutPutPort, times(1)).eliminarCuenta(anyInt());
    }

    @Test
    public void shouldEliminarCuentasExceptionNumeroCuenta(){
        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> service.eliminarCuentas(Collections.singletonList(cuenta)));
    }

    @Test
    public void shouldEliminarCuentasExceptionMovimientos(){
        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.of(cuenta));

        when(movimientoOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Collections.singletonList(Movimiento.builder().build()));

        assertThrows(BusinessException.class, () -> service.eliminarCuentas(Collections.singletonList(cuenta)));
    }
}