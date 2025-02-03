package com.online.shopping.controllers;

import com.online.shopping.dtos.ProductRequest;
import com.online.shopping.dtos.ProductResponse;
import com.online.shopping.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {
	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
		ProductResponse response = service.createProduct(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAllProducts() {
		List<ProductResponse> products = service.getAllProducts();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id){
		service.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
