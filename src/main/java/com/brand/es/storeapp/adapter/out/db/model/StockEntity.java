package com.brand.es.storeapp.adapter.out.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Entity(name = "Stock")
public class StockEntity
{
  @Id
  private Integer id;
  private Integer quantity;

  public StockEntity() {}

  public StockEntity( Integer id, Integer quantity )
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
