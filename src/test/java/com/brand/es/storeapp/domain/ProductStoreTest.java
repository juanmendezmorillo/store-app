package com.brand.es.storeapp.domain;

import org.junit.jupiter.api.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by JMENDEZ on 13/12/2022.
 */
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
@ActiveProfiles("test")
@Tag("UnitTest")
@DisplayName("Product Store Unit Tests")
public class ProductStoreTest {

    private ProductStore productStore;

    @BeforeAll
    public void init() {
        Stock stock1 = new Stock(1, 10);
        Stock stock2 = new Stock(2, 5);
        Stock stock3 = new Stock(3, 8);
        Size size1 = new Size(1, stock1, Boolean.TRUE, Boolean.FALSE);
        Size size2 = new Size(2, stock2, Boolean.FALSE, Boolean.TRUE);
        Size size3 = new Size(3, stock3, Boolean.TRUE, Boolean.FALSE);
        Product product1 = new Product(1, 10, new ArrayList<>(Arrays.asList(new Size[]{size1})));
        Product product2 = new Product(2, 5, new ArrayList<>(Arrays.asList(new Size[]{size2, size3})));

        productStore = new ProductStore(new ArrayList<>(Arrays.asList(new Product[]{product1, product2})));
    }

    @Test
    @DisplayName("when get Ids Products, then Ids Products is returned")
    void whenGetIdsProducts_ThenIdsProductsReturned() {

        //when
        String idsProductsFind = productStore.getIdsProductsBySizeAndStock();

        //then
        assertNotNull(idsProductsFind);
        assertEquals(String.valueOf("2,1"), idsProductsFind);
    }

}
