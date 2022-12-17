package com.brand.es.storeapp;

import com.brand.es.storeapp.domain.ProductStore;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Configuration
public class ApplicationConfiguration
{

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public ProductStore productStore() {
    return new ProductStore();
  }

}
