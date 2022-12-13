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
import java.util.Optional;
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
  public Optional<Integer> saveProduct( ProductDTO product )
  {
    return Optional.of( productRepository.save( modelMapper.map( product, ProductEntity.class ) ).getId() );
  }

  @Override
  public Optional<Integer> saveSize( SizeDTO size )
  {
    return Optional.of( sizeRepository.save( modelMapper.map( size, SizeEntity.class ) ).getId() );
  }

  @Override
  public Optional<Integer> saveStock( StockDTO stock )
  {
    return Optional.of( stockRepository.save( modelMapper.map( stock, StockEntity.class ) ).getId() );
  }

  @Override
  public Optional<ProductDTO> findProductById( Integer id )
  {
    Optional<ProductEntity> productEntity = productRepository.findById( id );
    if ( productEntity.isPresent() ) {
      return Optional.of( modelMapper.map( productEntity.get(), ProductDTO.class ) );
    }
    return Optional.empty();
  }

  @Override
  public Optional<StockDTO> findStockById( Integer id )
  {
    Optional<StockEntity> stockEntity = stockRepository.findById( id );
    if ( stockEntity.isPresent() ) {
      return Optional.of( modelMapper.map( stockEntity.get(), StockDTO.class ) );
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<ProductDTO>> getAllProducts()
  {
    List<ProductDTO> products =
      productRepository
      .findAll()
      .stream()
      .map( productEntity -> modelMapper.map( productEntity, ProductDTO.class ))
      .collect(Collectors.toList());

    if ( !products.isEmpty() ) {
      return Optional.of( products );
    }
    return Optional.empty();
  }

}
