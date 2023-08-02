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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RealizarMovimientoServiceTest {

    @InjectMocks
    private RealizarMovimientoService service;

    @Mock
    private MovimientoOutPutPort movimientoOutPutPort;

    @Mock
    private CuentaOutPutPort cuentaOutPutPort;

    private MovimientoDTO movimientoDTO;
    private Cuenta cuenta;
    private Movimiento movimiento;

    @BeforeEach
    public void setUp(){
        movimientoDTO = new MovimientoDTO();
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
    public void shouldRealizarMovimeintos(){
        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.of(cuenta));

        when(cuentaOutPutPort.guardarCuenta(any()))
                .thenReturn(cuenta);

        when(movimientoOutPutPort.guardarMovimiento(any()))
                .thenReturn(movimiento);

        List<Movimiento> movimientos = service.realizarMovimientos(Collections.singletonList(movimientoDTO));

        Assertions.assertNotNull(movimientos);
        Assertions.assertEquals(movimientos.get(0),movimiento);
    }

    @Test
    public void shouldRealizarMovimientosException(){
        when(cuentaOutPutPort.findByNumeroCuenta(anyInt()))
                .thenReturn(Optional.empty());

        assertThrows(BusinessException.class,() -> service.realizarMovimientos(Collections.singletonList(movimientoDTO)));
    }
}