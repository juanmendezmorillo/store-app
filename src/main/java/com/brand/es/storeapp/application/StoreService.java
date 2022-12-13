package com.brand.es.storeapp.application;

import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;

import java.util.Optional;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public interface StoreService
{
  Optional<Integer> saveProduct(ProductDTO product);
  Optional<Integer> saveSize(SizeDTO size);
  Optional<Integer> saveStock(StockDTO stock);
  Optional<ProductDTO> findProductById(Integer id);
  Optional<StockDTO> findStockById(Integer id);
  String getIdsProducts();
}
