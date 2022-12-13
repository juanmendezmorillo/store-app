package com.brand.es.storeapp.adapter.in.web;

import com.brand.es.storeapp.adapter.in.web.exception.ResourceNotFoundException;
import com.brand.es.storeapp.application.ProductService;
import com.brand.es.storeapp.port.in.web.WebPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Slf4j
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
    log.info( "GET /productstock" );

    String ids = productService.getIdsProducts();
    if (ids.isEmpty()) {
      throw new ResourceNotFoundException( "There are no products in stock" );
    }
    return new ResponseEntity<>(ids, HttpStatus.OK);
  }
}
