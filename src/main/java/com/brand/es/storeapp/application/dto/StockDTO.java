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
public class StockDTO
{
  private Integer id;
  private Integer quantity;
}
