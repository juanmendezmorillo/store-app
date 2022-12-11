package com.brand.es.storeapp.domain;

import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class Product
{
  private Integer id;
  private Integer sequence;
  private List<Size> sizes;

  public Product()
  {
  }

  public Product( Integer id, Integer sequence, List<Size> sizes )
  {
    this.id = id;
    this.sequence = sequence;
    this.sizes = sizes;
  }

  public Integer getId()
  {
    return id;
  }

  public Integer getSequence()
  {
    return sequence;
  }

  public List<Size> getSizes()
  {
    return sizes;
  }
}
