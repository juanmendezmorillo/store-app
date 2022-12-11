package com.brand.es.storeapp.adapter.out.db.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Entity(name = "Product")
public class ProductEntity
{
  @Id
  private Integer id;
  private Integer sequence;
  @OneToMany(mappedBy="product", fetch = FetchType.EAGER)
  private List<SizeEntity> sizes;

  public ProductEntity() {}

  public ProductEntity( Integer id, Integer sequence )
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

  public List<SizeEntity> getSizes()
  {
    return sizes;
  }

  public void setSizes( List<SizeEntity> sizes )
  {
    this.sizes = sizes;
  }
}
