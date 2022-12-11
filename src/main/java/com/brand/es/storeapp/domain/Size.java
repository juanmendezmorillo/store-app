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

  public Stock getStock()
  {
    return stock;
  }

  public Boolean getBackSoon()
  {
    return backSoon;
  }

  public Boolean getSpecial()
  {
    return special;
  }
}
