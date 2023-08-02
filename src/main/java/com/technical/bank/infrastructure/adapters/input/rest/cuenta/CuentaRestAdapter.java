package com.technical.bank.infrastructure.adapters.input.rest.cuenta;

import com.technical.bank.application.ports.input.cuenta.ActualizarCuentaUseCase;
import com.technical.bank.application.ports.input.cuenta.CrearCuentaUseCase;
import com.technical.bank.application.ports.input.cuenta.EliminarCuentaUseCase;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.infrastructure.adapters.input.rest.cuenta.dto.CuentaDTO;
import com.technical.bank.infrastructure.adapters.input.rest.cuenta.mapper.CuentaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cuenta")
@RequiredArgsConstructor
public class CuentaRestAdapter {

    private final CrearCuentaUseCase crearCuentaUseCase;
    private final ActualizarCuentaUseCase actualizarCuentaUseCase;
    private final EliminarCuentaUseCase eliminarCuentaUseCase;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cuenta> crearCuentas(@Valid @RequestBody List<CuentaDTO> cuentaDTOS){
        return crearCuentaUseCase.crearCuentas(CuentaMapper.CuentaDtoListToCuentaList(cuentaDTOS));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cuenta> actualizarCuentas(@Valid @RequestBody List<CuentaDTO> cuentaDTOS){
        return actualizarCuentaUseCase.actualizarCuentas(CuentaMapper.CuentaDtoListToCuentaList(cuentaDTOS));
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String eliminarCuentas(@Valid @RequestBody List<CuentaDTO> cuentaDTOS){
        eliminarCuentaUseCase.eliminarCuentas(CuentaMapper.CuentaDtoListToCuentaList(cuentaDTOS));

        return "Eliminacion Exitosa";
    }
}
