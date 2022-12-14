package com.brand.es.storeapp.port.in.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by JMENDEZ on 11/12/2022.
 */
@RequestMapping("/api")
public interface WebPort {

  @Operation(summary = "Obtain products IDs depending on the stock and sizes available")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Found Products Ids"),
    @ApiResponse(responseCode = "404", description = "Products ids not Found!"),
    @ApiResponse(responseCode = "500", description = "Server Error!"),})
  @GetMapping("/productstock")
  ResponseEntity<String> getProductStock();
}
