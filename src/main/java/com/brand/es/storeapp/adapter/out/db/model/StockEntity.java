package com.brand.es.storeapp.adapter.out.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "Stock")
public class StockEntity
{
  @Id
  private Integer id;
  private Integer quantity;
}
