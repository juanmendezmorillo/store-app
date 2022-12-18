package com.brand.es.storeapp.application.dto;

import com.brand.es.storeapp.adapter.out.db.model.StockEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by JMENDEZ on 18/12/2022.
 */
@ActiveProfiles("test")
@Tag("UnitTest")
@DisplayName("Stock Mapper Unit Tests")
public class StockDTOTest {

  private ModelMapper modelMapper = new ModelMapper();

  @Test
  @DisplayName("when convert StockEntity to StockDTO, then correct")
  public void whenConvertStockEntityToStockDTO_thenCorrect() {

    //given
    StockEntity stockEntity = StockEntity.builder().id(1).quantity(10).build();

    //when
    StockDTO stockDTO = modelMapper.map(stockEntity, StockDTO.class);

    //then
    assertEquals(stockDTO.getId(), stockEntity.getId());
    assertEquals(stockDTO.getQuantity(), stockEntity.getQuantity());
  }

  @Test
  @DisplayName("when convert StockDTO to StockEntity, then correct")
  public void whenConvertStockDTOToStockEntity_thenCorrect() {

    //given
    StockDTO stockDTO = StockDTO.builder().id(1).quantity(10).build();

    //when
    StockEntity stockEntity = modelMapper.map(stockDTO, StockEntity.class);

    //then
    assertEquals(stockEntity.getId(), stockDTO.getId());
    assertEquals(stockEntity.getQuantity(), stockDTO.getQuantity());
  }

}