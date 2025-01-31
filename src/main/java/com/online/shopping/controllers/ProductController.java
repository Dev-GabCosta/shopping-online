package com.online.shopping.controllers;

import com.online.shopping.dtos.ProductRequest;
import com.online.shopping.dtos.ProductResponse;
import com.online.shopping.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
