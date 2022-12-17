package com.brand.es.storeapp.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class ProductStore {

  public ProductStore()
  {
  }

  /**
   * Filter products based on size and stock attributes.
   *
   * @param products list of products to filter.
   * @return ids, comma separated product identifiers.
   */
  public String getIdsProductsBySizeAndStock(List<Product> products)
  {
    List<String> idsProduct = products
      .stream()
      .filter(product -> checkProductsBySizeAndStock(product))
      .sorted((p1, p2) -> p1.getSequence().compareTo(p2.getSequence()))
      .map(product -> String.valueOf(product.getId()))
      .collect(Collectors.toList());

    return String.join(",", idsProduct);
  }

  private boolean checkProductsBySizeAndStock(Product product)
  {
    return
      isProductBacksoon(product)
        || isProductSpecial(product);
  }

  private boolean isProductBacksoon(Product product)
  {
    return
      !foundSizeSpecial(product.getSizes())
        && foundSizeBacksoon(product.getSizes());
  }

  private boolean foundSizeSpecial(List<Size> sizes)
  {
    return sizes
      .stream()
      .anyMatch(
        size ->
          size.getSpecial()
      );
  }

  private boolean foundSizeBacksoon(List<Size> sizes)
  {
    return sizes
      .stream()
      .anyMatch(
        size ->
          size.getBackSoon()
      );
  }

  private boolean isProductSpecial(Product product)
  {
    return
      foundSizeSpecialAndBacksoonOrStockExistence(product.getSizes())
        && foundSizeNotSpecialAndBacksoonOrStockExistence(product.getSizes());
  }

  private boolean foundSizeSpecialAndBacksoonOrStockExistence(List<Size> sizes)
  {
    return sizes
      .stream()
      .filter(
        size ->
          size.getSpecial() &&
            (
              size.getBackSoon() ||
                (size.getStock() != null
                  ? size.getStock().getQuantity() > 0
                  : Boolean.FALSE
                )
            )
      ).count() > 0;
  }

  private boolean foundSizeNotSpecialAndBacksoonOrStockExistence(List<Size> sizes)
  {
    return sizes
      .stream()
      .filter(
        size ->
          !size.getSpecial() &&
            (
              size.getBackSoon() ||
                (size.getStock() != null
                  ? size.getStock().getQuantity() > 0
                  : Boolean.FALSE
                )
            )
      ).count() > 0;
  }
}
