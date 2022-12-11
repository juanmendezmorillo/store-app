package com.brand.es.storeapp.adapter.out.db.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Entity(name = "Size")
public class SizeEntity
{
  @Id
  private Integer id;
  @ManyToOne
  @JoinColumn(name="product_id", nullable=false)
  private ProductEntity product;
  @OneToOne
  @JoinColumn(name = "stock_id", referencedColumnName = "id")
  private StockEntity stock;
  private Boolean backSoon;
  private Boolean special;

  public SizeEntity() {}

  public SizeEntity( Integer id, ProductEntity product, StockEntity stock, Boolean backSoon, Boolean special )
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

  public ProductEntity getProduct()
  {
    return product;
  }

  public void setProduct( ProductEntity product )
  {
    this.product = product;
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
