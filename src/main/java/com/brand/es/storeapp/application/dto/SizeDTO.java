package com.brand.es.storeapp.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SizeDTO
{
  private Integer id;
  private ProductDTO product;
  private StockDTO stock;
  private Boolean backSoon;
  private Boolean special;
}
