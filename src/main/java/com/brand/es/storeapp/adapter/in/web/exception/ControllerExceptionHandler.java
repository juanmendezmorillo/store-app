package com.brand.es.storeapp.adapter.in.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ErrorMessage> productNotFoundException(
    ProductNotFoundException ex, WebRequest request) {

    log.error(ex.getMessage());
    return new ResponseEntity<>(
      new ErrorMessage(
        HttpStatus.NOT_FOUND.value(),
        LocalDateTime.now(),
        ex.getMessage(),
        request.getDescription(Boolean.FALSE)
      ), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(ProductInternalException.class)
  public ResponseEntity<ErrorMessage> productInternalException(
    ProductInternalException ex, WebRequest request) {

    log.error(ex.getMessage());
    return new ResponseEntity<>(
      new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        LocalDateTime.now(),
        ex.getMessage(),
        request.getDescription(Boolean.FALSE)
      ), HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
