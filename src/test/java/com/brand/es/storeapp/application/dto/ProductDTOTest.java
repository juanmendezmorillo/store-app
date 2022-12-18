package com.brand.es.storeapp.application.dto;

import com.brand.es.storeapp.adapter.out.db.model.ProductEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by JMENDEZ on 18/12/2022.
 */
@ActiveProfiles("test")
@Tag("UnitTest")
@DisplayName("Product Mapper Unit Tests")
public class ProductDTOTest {

  private ModelMapper modelMapper = new ModelMapper();

  @Test
  @DisplayName("when convert ProductEntity to ProductDTO, then correct")
  public void whenConvertProductEntityToProductDTO_thenCorrect() {

    //given
    ProductEntity product = ProductEntity.builder().id(1).sequence(10).sizes(new ArrayList<>()).build();

    //when
    ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

    //then
    assertEquals(productDTO.getId(), product.getId());
    assertEquals(productDTO.getSequence(), product.getSequence());
    assertEquals(productDTO.getSizes(), product.getSizes());
  }

  @Test
  @DisplayName("when convert ProductDTO to ProductEntity, then correct")
  public void whenConvertProductDTOToProductEntity_thenCorrect() {

    //given
    ProductDTO productDTO = ProductDTO.builder().id(1).sequence(10).sizes(new ArrayList<>()).build();

    //when
    ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);

    //then
    assertEquals(productEntity.getId(), productDTO.getId());
    assertEquals(productEntity.getSequence(), productDTO.getSequence());
    assertEquals(productEntity.getSizes(), productDTO.getSizes());
  }

}
