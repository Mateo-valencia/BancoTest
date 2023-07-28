package com.technical.bank.infrastructure.adapters.input.rest.cuenta.mapper;

import com.technical.bank.domain.model.cuenta.Cuenta;
import com.technical.bank.infrastructure.adapters.input.rest.cuenta.dto.CuentaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CuentaMapper {

    private CuentaMapper() {
    }

    public static List<Cuenta> CuentaDtoListToCuentaList(List<CuentaDTO> cuentaDTOS){
        return cuentaDTOS.stream()
                .map(cuentaDTO ->
                        Cuenta.builder()
                                .numero(cuentaDTO.getNumeroCuenta())
                                .tipo(cuentaDTO.getTipo())
                                .saldoInicial(cuentaDTO.getSaldoInicial())
                                .estado(cuentaDTO.isEstado())
                                .nombreCliente(cuentaDTO.getCliente())
                                .build()
                )
                .collect(Collectors.toList());
    }


}
