package com.brand.es.storeapp;

import com.brand.es.storeapp.application.ProductService;
import com.brand.es.storeapp.application.dto.ProductDTO;
import com.brand.es.storeapp.application.dto.SizeDTO;
import com.brand.es.storeapp.application.dto.StockDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class StoreAppApplication {

	private ProductService productService;

	public StoreAppApplication( ProductService productService )
	{
		this.productService = productService;
	}

	public static void main(String[] args)   {
		SpringApplication.run(StoreAppApplication.class, args);
	}

	@PostConstruct
	private void initializeDataFromFiles() {
		loadProducts();
		loadStocks();
		loadSizes();
	}

	private void loadProducts() {

		readFile("src/main/resources/csv/product.csv")
			.stream()
			.forEach( recordLine -> {
				productService.saveProduct(
					ProductDTO.builder()
						.id( Integer.valueOf( recordLine.get( 0 ).trim() ) )
						.sequence( Integer.valueOf( recordLine.get( 1 ).trim() ) ).build()
				);
			});
	}

	private void loadStocks() {

		readFile("src/main/resources/csv/stock.csv")
			.stream()
			.forEach( recordLine -> {
				productService.saveStock(
					StockDTO.builder()
					.id( Integer.valueOf( recordLine.get( 0 ).trim() ) )
					.quantity( Integer.valueOf( recordLine.get( 1 ).trim() ) )
					.build()
				);
			});
	}

	private void loadSizes() {

		readFile("src/main/resources/csv/size.csv")
			.stream()
			.forEach( recordLine -> {
				productService.saveSize(
					SizeDTO.builder()
					.id( Integer.valueOf( recordLine.get( 0 ).trim() ) )
					.product( productService.findProductById( Integer.valueOf( recordLine.get( 1 ).trim() ) ).orElse( null ) )
					.stock( productService.findStockById( Integer.valueOf( recordLine.get( 0 ).trim() ) ).orElse( null ) )
					.backSoon( Boolean.valueOf( recordLine.get( 2 ).trim() ) )
					.special( Boolean.valueOf( recordLine.get( 3 ).trim() ) )
					.build()
				);
			});
	}

	private List<List<String>> readFile(String file) {
		List<List<String>> records = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;

			while( ( line = br.readLine() ) != null )
			{
				String[] values = line.split( "," );
				records.add( Arrays.asList( values ) );
			}
		}
		catch( FileNotFoundException e )
		{
			System.out.println(file + " does not exist");
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}

		return records;
	}

}
