package com.bookstore.bookstore.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ControllerException {

    
    @ExceptionHandler(ObjetoNaoEncontrado.class)
    public ResponseEntity<StandartError> objetoNotFoudExeption( ObjetoNaoEncontrado e, ServletRequest request){
        StandartError error = new StandartError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(),e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandartError> dataIntegrityViolationException( DataIntegrityViolationException e, ServletRequest request){
        StandartError error = new StandartError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(),e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

   
}
