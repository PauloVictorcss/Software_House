package br.com.softwareGrup.comanda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IsNotPossibleToDoException extends RuntimeException{

    public IsNotPossibleToDoException(String ex){
        super(ex);
    }
}
