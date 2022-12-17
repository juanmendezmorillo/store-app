package com.brand.es.storeapp.loaddata;

import com.brand.es.storeapp.application.StoreService;
import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;
import com.brand.es.storeapp.loaddata.exception.LoadDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMENDEZ on 17/12/2022.
 */
@Slf4j
@Component
public class LoadData {

  private static final String LINE_SPLIT_CSV = ",";

  @Value("${path.product.csv}")
  private String pathProductCsv;
  @Value("${path.size.csv}")
  private String pathSizeCsv;
  @Value("${path.stock.csv}")
  private String pathStockCsv;

  private StoreService storeService;

  public LoadData(StoreService storeService) {
    this.storeService = storeService;
  }

  public void initializeDataFromFiles() throws LoadDataException
  {
    log.info("Load data from .csv files");

    try {
      loadProducts(pathProductCsv);
      loadStocks(pathStockCsv);
      loadSizes(pathSizeCsv);
    } catch (Exception e) {
      throw new LoadDataException(e.getMessage());
    }
  }

  private void loadProducts(String file) {

    readFile(file)
      .stream()
      .forEach(recordLine -> {
        storeService.saveProduct(
          ProductDTO.builder()
            .id(Integer.valueOf(recordLine.get(0).trim()))
            .sequence(Integer.valueOf(recordLine.get(1).trim())).build()
        );
      });
  }

  private void loadStocks(String file) {

    readFile(file)
      .stream()
      .forEach(recordLine -> {
        storeService.saveStock(
          StockDTO.builder()
            .id(Integer.valueOf(recordLine.get(0).trim()))
            .quantity(Integer.valueOf(recordLine.get(1).trim()))
            .build()
        );
      });
  }

  private void loadSizes(String file) {

    readFile(file)
      .stream()
      .forEach(recordLine -> {
        storeService.saveSize(
          SizeDTO.builder()
            .id(Integer.valueOf(recordLine.get(0).trim()))
            .product(storeService.findProductById(Integer.valueOf(recordLine.get(1).trim())).orElse(null))
            .stock(storeService.findStockById(Integer.valueOf(recordLine.get(0).trim())).orElse(null))
            .backSoon(Boolean.valueOf(recordLine.get(2).trim()))
            .special(Boolean.valueOf(recordLine.get(3).trim()))
            .build()
        );
      });
  }

  private List<List<String>> readFile(String file) {
    List<List<String>> records = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = br.readLine()) != null) {
        String[] values = line.split(LINE_SPLIT_CSV);
        records.add(Arrays.asList(values));
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return records;
  }


}
