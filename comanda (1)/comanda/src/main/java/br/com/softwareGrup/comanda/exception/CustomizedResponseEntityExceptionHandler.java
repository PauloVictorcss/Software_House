package br.com.softwareGrup.comanda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleBadNotFoundExceptions(
            EntityNotFoundException ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IsNotPossibleToDoException.class)
    public final ResponseEntity<ExceptionResponseMesa> handleBadNotFoundExceptionsMesa(
            IsNotPossibleToDoException ex, WebRequest request){

        ExceptionResponseMesa exceptionResponseMesa = new ExceptionResponseMesa(ex.getMessage());

        return new ResponseEntity<>(exceptionResponseMesa, HttpStatus.NOT_FOUND);
    }
}
