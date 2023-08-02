package com.technical.bank.domain.service.movimiento;

import com.technical.bank.application.ports.output.movimiento.MovimientoOutPutPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EliminarMovimientoServiceTest {

    @InjectMocks
    private EliminarMovimientoService service;

    @Mock
    private MovimientoOutPutPort movimientoOutPutPort;

    @Test
    public void shouldEliminarMovimeintos(){
        service.elimnarMovimientos(Arrays.asList("123DSD","12324B"));
        verify(movimientoOutPutPort, times(2)).eliminarMovimiento(anyString());
    }
}