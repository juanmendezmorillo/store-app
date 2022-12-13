package com.brand.es.storeapp.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDTO
{
  private Integer id;
  private Integer sequence;
  private List<SizeDTO> sizes;
}
