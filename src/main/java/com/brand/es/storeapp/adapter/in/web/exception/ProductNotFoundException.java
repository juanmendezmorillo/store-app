package com.brand.es.storeapp.adapter.in.web.exception;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
public class ProductNotFoundException extends RuntimeException
{
  public ProductNotFoundException(String message )
  {
    super( message );
  }
}
