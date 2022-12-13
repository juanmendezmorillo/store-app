package com.brand.es.storeapp.adapter.in.web.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
@AllArgsConstructor
@Data
public class ErrorMessage
{
  private int status;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss")
  private LocalDateTime timestamp;
  private String message;
  private String description;
}
