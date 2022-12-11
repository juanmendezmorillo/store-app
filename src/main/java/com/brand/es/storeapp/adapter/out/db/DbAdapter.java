package com.brand.es.storeapp.adapter.out.db;

import com.brand.es.storeapp.adapter.out.db.model.ProductEntity;
import com.brand.es.storeapp.adapter.out.db.model.SizeEntity;
import com.brand.es.storeapp.adapter.out.db.model.StockEntity;
import com.brand.es.storeapp.adapter.out.db.repository.ProductRepository;
import com.brand.es.storeapp.adapter.out.db.repository.SizeRepository;
import com.brand.es.storeapp.adapter.out.db.repository.StockRepository;
import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;
import com.brand.es.storeapp.port.out.db.DbPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@Service
public class DbAdapter implements DbPort
{
  private ProductRepository productRepository;
  private SizeRepository sizeRepository;
  private StockRepository stockRepository;
  private ModelMapper modelMapper;

  public DbAdapter(
    ProductRepository productRepository,
    SizeRepository sizeRepository,
    StockRepository stockRepository,
    ModelMapper modelMapper )
  {
    this.productRepository = productRepository;
    this.sizeRepository = sizeRepository;
    this.stockRepository = stockRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void saveProduct( ProductDTO product )
  {
    ProductEntity productEntity = modelMapper.map( product, ProductEntity.class );
    productRepository.save( productEntity );
  }

  @Override
  public void saveSize( SizeDTO size )
  {
    SizeEntity sizeEntity = modelMapper.map( size, SizeEntity.class );
    sizeRepository.save( sizeEntity );
  }

  @Override
  public void saveStock( StockDTO stock )
  {
    StockEntity stockEntity = modelMapper.map( stock, StockEntity.class );
    stockRepository.save( stockEntity );
  }

  @Override
  public List<ProductDTO> getAllProducts()
  {
    return productRepository
      .findAll()
      .stream()
      .map( productEntity -> modelMapper.map( productEntity, ProductDTO.class ))
      .collect(Collectors.toList());
  }

}
