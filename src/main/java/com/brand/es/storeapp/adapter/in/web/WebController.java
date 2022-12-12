package com.brand.es.storeapp.adapter.in.web;

import com.brand.es.storeapp.application.ProductService;
import com.brand.es.storeapp.port.in.web.WebPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@RestController
public class WebController implements WebPort
{
  private ProductService productService;

  public WebController( ProductService productService )
  {
    this.productService = productService;
  }

  @Override
  public ResponseEntity<String> getProductStock()
  {
    return new ResponseEntity<>(productService.getIdsProducts(), HttpStatus.OK);
  }
}
