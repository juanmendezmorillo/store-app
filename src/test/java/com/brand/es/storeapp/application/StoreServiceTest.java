package com.brand.es.storeapp.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;
import com.brand.es.storeapp.port.out.db.DbPort;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by JMENDEZ on 13/12/2022.
 */
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
@ActiveProfiles("test")
@Tag("UnitTest")
@DisplayName("Product Service Unit Tests")
public class StoreServiceTest
{
  private DbPort dbPortMock;
  private StoreService storeService;

  @BeforeAll
  public void init() {
    dbPortMock = Mockito.mock( DbPort.class );
    storeService = new StoreServiceImpl( dbPortMock, new ModelMapper() );
  }

  @Test
  @DisplayName("given Product data, when save new Product, then Product id is returned")
  void givenProductData_whenSaveProduct_ThenProductIdReturned() {

    //given
    ProductDTO productDto =
      ProductDTO.builder()
        .id(1)
        .sequence(10)
        .build();
    Optional<Integer> idProduct = Optional.of(productDto.getId());

    //when
    when(dbPortMock.saveProduct(any(ProductDTO.class))).thenReturn(idProduct);
    Optional<Integer> idProductSave = storeService.saveProduct(productDto);

    //then
    assertNotNull(idProductSave.get());
    assertEquals(idProduct.get(), idProductSave.get());
  }

  @Test
  @DisplayName("given Size data, when save new Size, then Size id is returned")
  void givenSizeData_whenSaveSize_ThenSizeIdReturned() {

    //given
    SizeDTO sizeDto =
      SizeDTO.builder()
        .id(1)
        .product(ProductDTO.builder().id(1).sequence(10).build())
        .stock(StockDTO.builder().id(20).quantity(10).build())
        .backSoon( Boolean.TRUE )
        .special( Boolean.FALSE )
        .build();
    Optional<Integer> idSize = Optional.of(sizeDto.getId());

    //when
    when(dbPortMock.saveSize(any(SizeDTO.class))).thenReturn(idSize);
    Optional<Integer> idSizeSave = storeService.saveSize(sizeDto);

    //then
    assertNotNull(idSizeSave.get());
    assertEquals(idSize.get(), idSizeSave.get());
  }

  @Test
  @DisplayName("given Stock data, when save new Stock, then Stock id is returned")
  void givenStockData_whenSaveStock_ThenStockIdReturned() {

    //given
    StockDTO stockDto =
      StockDTO.builder()
        .id(1)
        .quantity( 10 )
        .build();
    Optional<Integer> idStock = Optional.of(stockDto.getId());

    //when
    when(dbPortMock.saveStock(any(StockDTO.class))).thenReturn(idStock);
    Optional<Integer> idStockSave = storeService.saveStock(stockDto);

    //then
    assertNotNull(idStockSave.get());
    assertEquals(idStock.get(), idStockSave.get());
  }

  @Test
  @DisplayName("given Product data, when find Product id, then Product is returned")
  void givenProductData_whenFindProductById_ThenProductReturned() {

    //given
    ProductDTO productDto =
      ProductDTO.builder()
        .id(1)
        .sequence(10)
        .build();
    Optional<ProductDTO> optionalProductDto = Optional.of(productDto);

    //when
    when(dbPortMock.findProductById(any(Integer.class))).thenReturn(optionalProductDto);
    Optional<ProductDTO> optionalProductDtoFind = storeService.findProductById(productDto.getId());

    //then
    assertNotNull(optionalProductDtoFind.get());
    assertEquals(optionalProductDto.get().getId(), optionalProductDtoFind.get().getId());
  }

  @Test
  @DisplayName("given Stock data, when find Stock id, then Stock is returned")
  void givenStockData_whenFindStockById_ThenStockReturned() {

    //given
    StockDTO stockDto =
      StockDTO.builder()
        .id(1)
        .quantity(10)
        .build();
    Optional<StockDTO> optionalStockDto = Optional.of(stockDto);

    //when
    when(dbPortMock.findStockById(any(Integer.class))).thenReturn(optionalStockDto);
    Optional<StockDTO> optionalStockDtoFind = storeService.findStockById(stockDto.getId());

    //then
    assertNotNull(optionalStockDtoFind.get());
    assertEquals(optionalStockDto.get().getId(), optionalStockDtoFind.get().getId());
  }

  @Test
  @DisplayName("given Ids Products data, when get Ids Products, then Ids Products is returned")
  void givenIdsProductsData_whenGetIdsProducts_ThenIdsProductsReturned() {
    Integer idProduct = 1;
    //given
    ProductDTO productDTO =
      ProductDTO.builder()
        .id(idProduct)
        .sequence(10)
        .sizes(
          new ArrayList<>(
            Arrays.asList(
              new SizeDTO[]{
                SizeDTO.builder()
                  .id(1)
                  .product(
                    ProductDTO.builder()
                      .id(idProduct)
                      .sequence(10)
                      .build())
                  .stock(
                    StockDTO.builder()
                      .id(1)
                      .quantity(5)
                      .build())
                  .backSoon(Boolean.TRUE)
                  .special(Boolean.FALSE)
                  .build()
              }
            )
          )
        ).build();
    Optional<List<ProductDTO>> optionalListProductDto =
      Optional.of(new ArrayList<>(Arrays.asList(new ProductDTO[]{productDTO})));

    //when
    when(dbPortMock.getAllProducts()).thenReturn(optionalListProductDto);
    String idsProductsFind = storeService.getIdsProducts();

    //then
    assertNotNull(idsProductsFind);
    assertEquals(String.valueOf(idProduct), idsProductsFind);
  }

}
