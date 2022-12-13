package com.brand.es.storeapp.adapter.out.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "Product")
public class ProductEntity
{
  @Id
  private Integer id;
  private Integer sequence;
  @OneToMany(mappedBy="product", fetch = FetchType.EAGER)
  private List<SizeEntity> sizes;
}
