package com.brand.es.storeapp.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class ProductStore
{
  private List<Product> products;

  public ProductStore( List<Product> products )
  {
    this.products = products;
  }

  public String getIdsProductsBySizeAndStock() {

    List<String> result = this.products
      .stream()
      .filter( product ->
        ( // product 'size' type 'backsoon'
          product.getSizes()
            .stream()
            .noneMatch(
              size ->
                size.getSpecial()
            )
          &&
          product.getSizes()
            .stream()
            .anyMatch(
              size ->
                size.getBackSoon()
            )
        )
        ||
        ( // product 'size' type 'special'
          product.getSizes()
            .stream()
            .anyMatch(
              size ->
                size.getSpecial()
            )
          &&
          product.getSizes()
            .stream()
            .filter(
              size ->
                size.getSpecial() &&
                  (
                    size.getBackSoon() ||
                      (	size.getStock() != null
                        ? size.getStock().getQuantity() > 0
                        : Boolean.FALSE
                      )
                  )
            ).count() > 0
          &&
          product.getSizes()
            .stream()
            .filter(
              size ->
                !size.getSpecial() &&
                  (
                    size.getBackSoon() ||
                      (	size.getStock() != null
                        ? size.getStock().getQuantity() > 0
                        : Boolean.FALSE
                      )
                  )
            ).count() > 0
        )
      )
      .sorted( ( product1, product2 ) -> product1.getSequence().compareTo( product2.getSequence() ) )
      .map( product -> String.valueOf( product.getId() ) )
      .collect(Collectors.toList());

      return String.join(",", result);

  }

}
