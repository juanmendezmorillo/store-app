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
      .filter( product -> {
        return
          Product.isProductBacksoon( product ) ||
          Product.isProductSpecial( product );
      })
      .sorted( ( p1, p2 ) -> p1.getSequence().compareTo( p2.getSequence() ) )
      .map( product -> String.valueOf( product.getId() ) )
      .collect(Collectors.toList());

      return String.join(",", result);

  }

}
