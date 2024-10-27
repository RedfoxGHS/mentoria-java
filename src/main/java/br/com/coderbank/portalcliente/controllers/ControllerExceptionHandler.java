package br.com.coderbank.portalcliente.controllers;

import br.com.coderbank.portalcliente.exceptions.ClienteJaExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ClienteJaExistenteException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ProblemDetail conflict(final Throwable exception) {
        ProblemDetail problemDetail =  ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, exception.getMessage());
        problemDetail.setTitle("Erro de conflito");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }
}
