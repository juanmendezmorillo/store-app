package com.brand.es.storeapp.application;

import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;
import com.brand.es.storeapp.domain.Product;
import com.brand.es.storeapp.domain.ProductStore;
import com.brand.es.storeapp.port.out.db.DbPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Service
public class ProductService
{
  private DbPort dbPort;
  private ModelMapper modelMapper;

  public ProductService( DbPort dbPort, ModelMapper modelMapper )
  {
    this.dbPort = dbPort;
    this.modelMapper = modelMapper;
  }

  public void saveProduct(ProductDTO product) {
    this.dbPort.saveProduct( product );
  }

  public void saveSize(SizeDTO size) {
    this.dbPort.saveSize( size );
  }

  public void saveStock(StockDTO stock) {
    this.dbPort.saveStock( stock );
  }

  public String getIdsProducts() {

    ProductStore productStore = new ProductStore(
      this.dbPort.getAllProducts()
        .stream()
        .map( productDTO -> modelMapper.map( productDTO, Product.class ) )
        .collect( Collectors.toList())
    );

    return productStore.getIdsProductsBySizeAndStock();
  }

}
