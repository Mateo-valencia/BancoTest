package com.technical.bank.infrastructure.adapters.input.rest.cuenta;

import com.technical.bank.application.ports.input.cuenta.CrearCuentaUseCase;
import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.infrastructure.adapters.input.rest.cuenta.dto.CuentaDTO;
import com.technical.bank.infrastructure.adapters.input.rest.cuenta.mapper.CuentaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cuenta")
@RequiredArgsConstructor
public class CuentaRestAdapter {

    private final CrearCuentaUseCase crearCuentaUseCase;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cuenta> crearCuentas(@Valid @RequestBody List<CuentaDTO> cuentaDTOS){
        return crearCuentaUseCase.crearCuentas(CuentaMapper.CuentaDtoListToCuentaList(cuentaDTOS));
    }
}
