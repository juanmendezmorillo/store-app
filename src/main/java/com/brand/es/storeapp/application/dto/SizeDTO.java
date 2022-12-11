package com.brand.es.storeapp.application.dto;

import com.brand.es.storeapp.adapter.out.db.model.StockEntity;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class SizeDTO
{
  private Integer id;
  private StockEntity stock;
  private Boolean backSoon;
  private Boolean special;

  public Integer getId()
  {
    return id;
  }

  public void setId( Integer id )
  {
    this.id = id;
  }

  public StockEntity getStock()
  {
    return stock;
  }

  public void setStock( StockEntity stock )
  {
    this.stock = stock;
  }

  public Boolean getBackSoon()
  {
    return backSoon;
  }

  public void setBackSoon( Boolean backSoon )
  {
    this.backSoon = backSoon;
  }

  public Boolean getSpecial()
  {
    return special;
  }

  public void setSpecial( Boolean special )
  {
    this.special = special;
  }
}
