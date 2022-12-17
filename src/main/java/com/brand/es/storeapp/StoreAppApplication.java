package com.brand.es.storeapp;

import com.brand.es.storeapp.loaddata.LoadData;
import com.brand.es.storeapp.loaddata.exception.LoadDataException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class StoreAppApplication {

	private LoadData loadData;

	public static void main(String[] args) {
		SpringApplication.run(StoreAppApplication.class, args);
	}

	@PostConstruct
	private void loadData() {
		try {
			this.loadData.initializeDataFromFiles();
		} catch (LoadDataException e) {
			log.error("Error load from .csv files , Error: " + e.getMessage());
		}

	}

}
