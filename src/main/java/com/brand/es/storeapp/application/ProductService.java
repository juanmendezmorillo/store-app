package com.brand.es.storeapp.application;

import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;

import java.util.Optional;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public interface ProductService
{
  void saveProduct(ProductDTO product);
  void saveSize(SizeDTO size);
  void saveStock(StockDTO stock);
  Optional<ProductDTO> findProductById(Integer id);
  Optional<StockDTO> findStockById(Integer id);
  String getIdsProducts();
}
