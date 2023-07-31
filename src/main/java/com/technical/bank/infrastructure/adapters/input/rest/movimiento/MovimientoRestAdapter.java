package com.technical.bank.infrastructure.adapters.input.rest.movimiento;

import com.technical.bank.application.ports.input.movimiento.RealizarMovimientosUseCase;
import com.technical.bank.domain.model.movimiento.Movimiento;
import com.technical.bank.infrastructure.adapters.input.rest.movimiento.dto.MovimientoDTO;
import com.technical.bank.infrastructure.adapters.output.persitence.movimiento.MovimientoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movimiento")
@RequiredArgsConstructor
public class MovimientoRestAdapter {

    private final RealizarMovimientosUseCase realizarMovimientosUseCase;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movimiento> realizarMovimientos(@Valid @RequestBody List<MovimientoDTO> movimientoDTOS){
        return realizarMovimientosUseCase.realizarMovimientos(movimientoDTOS);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovimientoCliente> getMovimientosCliente(@RequestParam String nombreCliente){
        return realizarMovimientosUseCase.getMovimientosCliente(nombreCliente);
    }
}
