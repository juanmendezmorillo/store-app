package com.brand.es.storeapp.application;

import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;
import com.brand.es.storeapp.domain.Product;
import com.brand.es.storeapp.domain.ProductStore;
import com.brand.es.storeapp.port.out.db.DbPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
@Service
public class ProductServiceImpl implements ProductService
{
  private DbPort dbPort;
  private ModelMapper modelMapper;

  public ProductServiceImpl( DbPort dbPort, ModelMapper modelMapper )
  {
    this.dbPort = dbPort;
    this.modelMapper = modelMapper;
  }

  @Override
  public void saveProduct( ProductDTO product )
  {
    dbPort.saveProduct( product );
  }

  @Override
  public void saveSize( SizeDTO size )
  {
    dbPort.saveSize( size );
  }

  @Override
  public void saveStock( StockDTO stock )
  {
    dbPort.saveStock( stock );
  }

  @Override
  public Optional<ProductDTO> findProductById( Integer id )
  {
    return dbPort.findProductById( id );
  }

  @Override
  public Optional<StockDTO> findStockById( Integer id )
  {
    return dbPort.findStockById( id );
  }

  @Override
  public String getIdsProducts()
  {
    ProductStore productStore = new ProductStore(
      dbPort.getAllProducts().get()
        .stream()
        .map( productDTO -> modelMapper.map( productDTO, Product.class ) )
        .collect( Collectors.toList())
    );

    return productStore.getIdsProductsBySizeAndStock();
  }
}
