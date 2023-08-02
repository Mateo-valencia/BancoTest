package com.technical.bank.infrastructure.adapters.input.rest.error;

import com.technical.bank.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({BusinessException.class,RuntimeException.class,Exception.class})
    public final ResponseEntity<ErrorDTO> handlePrestamoExceptions(BusinessException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMensaje(exception.getMessage());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
