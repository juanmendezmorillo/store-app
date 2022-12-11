package com.brand.es.storeapp.port.out.db;

import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;

import java.util.List;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
public interface DbPort
{
  void saveProduct(ProductDTO product);
  void saveSize(SizeDTO size);
  void saveStock(StockDTO stock);
  List<ProductDTO> getAllProducts();
}
