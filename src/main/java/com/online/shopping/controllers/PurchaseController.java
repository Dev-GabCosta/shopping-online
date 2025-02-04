package com.online.shopping.controllers;

import com.online.shopping.dtos.PurchaseRequest;
import com.online.shopping.dtos.PurchaseResponse;
import com.online.shopping.services.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class PurchaseController {
	private final PurchaseService service;

	public PurchaseController(PurchaseService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<PurchaseResponse> createPurchase(@RequestBody PurchaseRequest request) {
		PurchaseResponse response =  service.createPurchase(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
