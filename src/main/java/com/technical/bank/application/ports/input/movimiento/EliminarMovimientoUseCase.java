package com.technical.bank.application.ports.input.movimiento;

import java.util.List;

public interface EliminarMovimientoUseCase {

    void elimnarMovimientos(List<String> ids);
}
