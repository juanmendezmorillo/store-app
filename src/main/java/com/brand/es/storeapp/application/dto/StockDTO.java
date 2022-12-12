package com.brand.es.storeapp.application.dto;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class StockDTO
{
  private Integer id;
  private Integer quantity;

  public StockDTO() {}

  public StockDTO( Integer id, Integer quantity )
  {
    this.id = id;
    this.quantity = quantity;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId( Integer id )
  {
    this.id = id;
  }

  public Integer getQuantity()
  {
    return quantity;
  }

  public void setQuantity( Integer quantity )
  {
    this.quantity = quantity;
  }
}
