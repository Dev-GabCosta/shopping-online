package com.online.shopping.controllers;

import com.online.shopping.dtos.CustomerRequest;
import com.online.shopping.dtos.CustomerResponse;
import com.online.shopping.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest request) {
		CustomerResponse response = service.createCustomer(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
		List<CustomerResponse> customers = service.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}

}
