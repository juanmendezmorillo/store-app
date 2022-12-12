package com.brand.es.storeapp.domain;

import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public class Product
{
  private Integer id;
  private Integer sequence;
  private List<Size> sizes;

  public Product()
  {
  }

  public Product( Integer id, Integer sequence, List<Size> sizes )
  {
    this.id = id;
    this.sequence = sequence;
    this.sizes = sizes;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId( Integer id )
  {
    this.id = id;
  }

  public Integer getSequence()
  {
    return sequence;
  }

  public void setSequence( Integer sequence )
  {
    this.sequence = sequence;
  }

  public List<Size> getSizes()
  {
    return sizes;
  }

  public void setSizes( List<Size> sizes )
  {
    this.sizes = sizes;
  }

  public static boolean isProductBacksoon( Product product) {

    boolean foundSizeSpecial =
      product.getSizes()
        .stream()
        .anyMatch(
          size ->
            size.getSpecial()
        );

    boolean foundSizeBacksoon =
      product.getSizes()
        .stream()
        .anyMatch(
          size ->
            size.getBackSoon()
        );

    return
      !foundSizeSpecial &&
      foundSizeBacksoon;
  }

  public static boolean isProductSpecial( Product product) {

    boolean foundSizeSpecial =
      product.getSizes()
        .stream()
        .anyMatch(
          size ->
            size.getSpecial()
        );

    boolean foundSizeSpecialAndBacksoonOrStockExistence =
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
        ).count() > 0;

      boolean foundSizeNotSpecialAndBacksoonOrStockExistence =
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
        ).count() > 0;

      return
        foundSizeSpecial &&
        foundSizeSpecialAndBacksoonOrStockExistence &&
        foundSizeNotSpecialAndBacksoonOrStockExistence;

  }

}
