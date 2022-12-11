package com.brand.es.storeapp.domain;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class Stock
{
  private Integer id;
  private Integer quantity;

  public Stock()
  {
  }

  public Stock( Integer id, Integer quantity )
  {
    this.id = id;
    this.quantity = quantity;
  }

  public Integer getQuantity()
  {
    return quantity;
  }
}
