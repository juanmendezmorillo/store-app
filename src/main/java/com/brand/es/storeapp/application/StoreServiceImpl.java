package com.brand.es.storeapp.application;

import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;
import com.brand.es.storeapp.domain.Product;
import com.brand.es.storeapp.domain.ProductStore;
import com.brand.es.storeapp.port.out.db.DbPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by JMENDEZ on 12/12/2022.
 */
@AllArgsConstructor
@Service
public class StoreServiceImpl implements StoreService
{
  private DbPort dbPort;
  private ModelMapper modelMapper;
  private ProductStore productStore;

  @Override
  public Optional<Integer>  saveProduct( ProductDTO product )
  {
    return dbPort.saveProduct( product );
  }

  @Override
  public Optional<Integer>  saveSize( SizeDTO size )
  {
    return dbPort.saveSize( size );
  }

  @Override
  public Optional<Integer>  saveStock( StockDTO stock )
  {
    return dbPort.saveStock( stock );
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
    return
      productStore.getIdsProductsBySizeAndStock(
        dbPort.getAllProducts()
          .get()
          .stream()
          .map( productDTO -> modelMapper.map( productDTO, Product.class ) )
          .collect( Collectors.toList())
      );
  }
}
