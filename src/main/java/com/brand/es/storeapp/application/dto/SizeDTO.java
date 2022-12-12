package com.brand.es.storeapp.application.dto;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class SizeDTO
{
  private Integer id;
  private ProductDTO product;
  private StockDTO stock;
  private Boolean backSoon;
  private Boolean special;

  public SizeDTO() {}

  public SizeDTO( Integer id, ProductDTO product, StockDTO stock, Boolean backSoon, Boolean special )
  {
    this.id = id;
    this.product = product;
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

  public ProductDTO getProduct()
  {
    return product;
  }

  public void setProduct( ProductDTO product )
  {
    this.product = product;
  }

  public StockDTO getStock()
  {
    return stock;
  }

  public void setStock( StockDTO stock )
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
