package com.brand.es.storeapp.adapter.in.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
@RestControllerAdvice
public class ControllerExceptionHandler
{

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

    return new ErrorMessage(
      HttpStatus.NOT_FOUND.value(),
      LocalDateTime.now(),
      ex.getMessage(),
      request.getDescription( Boolean.FALSE )
    );

  }

}
