package com.brand.es.storeapp.application.dto;

import com.brand.es.storeapp.adapter.out.db.model.SizeEntity;

import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class ProductDTO
{
  private Integer id;
  private Integer sequence;
  private List<SizeEntity> sizes;

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

  public List<SizeEntity> getSizes()
  {
    return sizes;
  }

  public void setSizes( List<SizeEntity> sizes )
  {
    this.sizes = sizes;
  }
}
