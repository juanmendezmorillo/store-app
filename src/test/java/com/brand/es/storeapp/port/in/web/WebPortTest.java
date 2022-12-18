package com.brand.es.storeapp.port.in.web;

import com.brand.es.storeapp.application.StoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by JMENDEZ on 18/12/2022.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Tag("IntegrationTest")
@DisplayName("WebPort Integration Tests")
public class WebPortTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StoreService storeService;

  @Test
  @DisplayName("get the ids of the products with stock")
  public void getProductStockReturn200() throws Exception {

    //given
    given(this.storeService.getIdsProducts()).willReturn("5,1,3");

    //when-then
    this.mockMvc.perform(get("/api/productstock"))
      .andExpect(status().isOk());

  }

  @Test
  @DisplayName("get non exists products ids with stock")
  public void getNotExistsProductStockReturn404() throws Exception {

    //given
    given(this.storeService.getIdsProducts()).willReturn("");

    //when-then
    this.mockMvc.perform(get("/api/productstock"))
      .andExpect(status().isNotFound());

  }

}
