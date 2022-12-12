package com.brand.es.storeapp.domain;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class Size
{
  private Integer id;
  private Stock stock;
  private Boolean backSoon;
  private Boolean special;

  public Size()
  {
  }

  public Size( Integer id, Stock stock, Boolean backSoon, Boolean special )
  {
    this.id = id;
    this.stock = stock;
    this.backSoon = backSoon;
    this.special = special;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId( Integer id )
  {
    this.id = id;
  }

  public Stock getStock()
  {
    return stock;
  }

  public void setStock( Stock stock )
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
