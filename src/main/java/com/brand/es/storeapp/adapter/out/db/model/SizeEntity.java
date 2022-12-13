package com.brand.es.storeapp.adapter.out.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
}
