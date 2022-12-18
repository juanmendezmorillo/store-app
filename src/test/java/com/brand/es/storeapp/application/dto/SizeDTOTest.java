package com.brand.es.storeapp.application.dto;

import com.brand.es.storeapp.adapter.out.db.model.SizeEntity;
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
@DisplayName("Size Mapper Unit Tests")
public class SizeDTOTest {

  private ModelMapper modelMapper = new ModelMapper();

  @Test
  @DisplayName("when convert SizeEntity to SizeDTO, then correct")
  public void whenConvertSizeEntityToSizeDTO_thenCorrect() {

    //given
    SizeEntity sizeEntity = SizeEntity.builder().id(1).backSoon(Boolean.TRUE).special(Boolean.FALSE).build();

    //when
    SizeDTO sizeDTO = modelMapper.map(sizeEntity, SizeDTO.class);

    //then
    assertEquals(sizeDTO.getId(), sizeEntity.getId());
    assertEquals(sizeDTO.getBackSoon(), sizeEntity.getBackSoon());
    assertEquals(sizeDTO.getSpecial(), sizeEntity.getSpecial());
  }

  @Test
  @DisplayName("when convert SizeDTO to SizeEntity, then correct")
  public void whenConvertSizeDTOToSizeEntity_thenCorrect() {

    //given
    SizeDTO sizeDTO = SizeDTO.builder().id(1).backSoon(Boolean.TRUE).special(Boolean.FALSE).build();

    //when
    SizeEntity sizeEntity = modelMapper.map(sizeDTO, SizeEntity.class);

    //then
    assertEquals(sizeEntity.getId(), sizeDTO.getId());
    assertEquals(sizeEntity.getBackSoon(), sizeDTO.getBackSoon());
    assertEquals(sizeEntity.getSpecial(), sizeDTO.getSpecial());
  }

}