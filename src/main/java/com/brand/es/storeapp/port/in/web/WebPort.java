package com.brand.es.storeapp.port.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public interface WebPort
{
  @GetMapping("/productstock")
  ResponseEntity<String> getProductStock();
}
