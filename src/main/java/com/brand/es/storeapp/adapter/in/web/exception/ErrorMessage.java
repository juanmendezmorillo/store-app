package com.brand.es.storeapp.adapter.in.web.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
public class ErrorMessage
{
  private static final String DATE_FORMATTER_PATTERN = "dd-MM-yyy HH:mm:ss";

  private int status;
  private LocalDateTime localDateTime;
  private String message;
  private String description;


  public ErrorMessage( int status, LocalDateTime localDateTime, String message, String description )
  {
    this.status = status;
    this.localDateTime = localDateTime;
    this.message = message;
    this.description = description;
  }

  public int getStatus()
  {
    return status;
  }

  public void setStatus( int status )
  {
    this.status = status;
  }

  public String getLocalDateTime()
  {
    return localDateTime.format( DateTimeFormatter.ofPattern( DATE_FORMATTER_PATTERN ) );
  }

  public void setLocalDateTime( LocalDateTime localDateTime )
  {
    this.localDateTime = localDateTime;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage( String message )
  {
    this.message = message;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription( String description )
  {
    this.description = description;
  }
}
