package com.brand.es.storeapp;

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

}
