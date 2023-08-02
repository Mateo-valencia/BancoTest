package com.technical.bank.domain.service.movimiento;

import com.technical.bank.application.ports.output.cuenta.CuentaOutPutPort;
import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import com.technical.bank.domain.exception.BusinessException;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarMovimientoServiceTest {

    @InjectMocks
    private ActualizarMovimientoService service;

    @Mock
    private MovimientoOutPutPort movimientoOutPutPort;

    @Mock
    private CuentaOutPutPort cuentaOutPutPort;

    @Mock
    private RealizarMovimientoService realizarMovimientoService;

    private MovimientoDTO movimientoDTO;
    private Cuenta cuenta;
    private Movimiento movimiento;

    @BeforeEach
    public void setUp(){
        movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId("DFWD123");
        movimientoDTO.setNumeroCuenta(44568);
        movimientoDTO.setTipo("Deposito");
        movimientoDTO.setSaldoInicial(1000);
        movimientoDTO.setEstado(true);
        movimientoDTO.setMovimiento(100);

        cuenta = Cuenta.builder()
                .numero(41154)
                .tipo("Ahorros")
                .saldoInicial(1000)
                .saldoDisponible(1000)
                .estado(true)
                .nombreCliente("Juan Carlos")
                .build();

        movimiento = Movimiento.builder()
                .id(UUID.randomUUID().toString())
                .fecha(new Date())
                .tipo(movimientoDTO.getTipo())
                .valor(movimientoDTO.getMovimiento())
                .build();
    }


    @Test
    public void shouldActualizarMovimientos(){
        when(movimientoOutPutPort.findById(anyString()))
                .thenReturn(Optional.of(movimiento));

        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.of(cuenta));

        when(realizarMovimientoService.realizarOperacion(any(),any()))
                .thenReturn(cuenta);

        when(cuentaOutPutPort.guardarCuenta(any()))
                .thenReturn(cuenta);

        when(movimientoOutPutPort.guardarMovimiento(any()))
                .thenReturn(movimiento);


        List<Movimiento> movimientos = service.actualizarMovimientos(Collections.singletonList(movimientoDTO));

        Assertions.assertNotNull(movimientos);
        Assertions.assertEquals(movimientos.get(0),movimiento);
    }

    @Test
    public void shouldActualizarMovimientosExceptionNotFound(){
        when(movimientoOutPutPort.findById(anyString()))
                .thenReturn(Optional.empty());

        assertThrows(BusinessException.class,() -> service.actualizarMovimientos(Collections.singletonList(movimientoDTO)));
    }

    @Test
    public void shouldActualizarMovimientosExceptionNotFoundCuenta(){
        when(movimientoOutPutPort.findById(anyString()))
                .thenReturn(Optional.of(movimiento));

        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.empty());

        assertThrows(BusinessException.class,() -> service.actualizarMovimientos(Collections.singletonList(movimientoDTO)));
    }
}