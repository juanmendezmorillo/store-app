package com.brand.es.storeapp.adapter.in.web.exception;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
public class ResourceNotFoundException extends RuntimeException
{
  public ResourceNotFoundException( String message )
  {
    super( message );
  }
}
