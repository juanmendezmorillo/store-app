package com.brand.es.storeapp.adapter.in.web;

import com.brand.es.storeapp.adapter.in.web.exception.ProductInternalException;
import com.brand.es.storeapp.adapter.in.web.exception.ProductNotFoundException;
import com.brand.es.storeapp.application.StoreService;
import com.brand.es.storeapp.port.in.web.WebPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@AllArgsConstructor
@Slf4j
@RestController
public class WebController implements WebPort
{
  private StoreService storeService;

  @Override
  public ResponseEntity<String> getProductStock()
  {
    log.info( "GET /productstock" );

    String ids = "";

    try {
      ids = storeService.getIdsProducts();
    } catch (Exception ex) {
      throw new
        ProductInternalException("An unexpected error has occurred while trying to obtain the products, contact dev@brand.es");
    }

    if (ids.isEmpty()) {
      throw new ProductNotFoundException("There are no products in stock");
    }

    return new ResponseEntity<>(ids, HttpStatus.OK);

  }
}
