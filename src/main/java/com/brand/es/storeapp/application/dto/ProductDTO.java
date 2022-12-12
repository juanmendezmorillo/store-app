package com.brand.es.storeapp.application.dto;

import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class ProductDTO
{
  private Integer id;
  private Integer sequence;
  private List<SizeDTO> sizes;

  public ProductDTO() {}

  public ProductDTO( Integer id, Integer sequence )
  {
    this.id = id;
    this.sequence = sequence;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId( Integer id )
  {
    this.id = id;
  }

  public Integer getSequence()
  {
    return sequence;
  }

  public void setSequence( Integer sequence )
  {
    this.sequence = sequence;
  }

  public List<SizeDTO> getSizes()
  {
    return sizes;
  }

  public void setSizes( List<SizeDTO> sizes )
  {
    this.sizes = sizes;
  }
}
