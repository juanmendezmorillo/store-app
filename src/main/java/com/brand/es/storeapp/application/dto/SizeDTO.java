package com.brand.es.storeapp.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
  @NotNull( message = "Product is mandatory")
  private ProductDTO product;
  private StockDTO stock;
  @NotNull( message = "BackSoon is mandatory")
  private Boolean backSoon;
  @NotNull( message = "Special is mandatory")
  private Boolean special;
}
