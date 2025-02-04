package com.online.shopping.controllers;

import com.online.shopping.dtos.CustomerRequest;
import com.online.shopping.dtos.CustomerResponse;
import com.online.shopping.dtos.UpdateCustomerEmailDTO;
import com.online.shopping.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	public ResponseEntity<CustomerResponse> createCustomer(@Validated @RequestBody CustomerRequest request) {
		CustomerResponse response = service.createCustomer(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
		List<CustomerResponse> customers = service.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}

	@PatchMapping("/{id}/email")
	public  ResponseEntity<CustomerResponse> updateCustomerEmail(@PathVariable Long id, @RequestBody UpdateCustomerEmailDTO emailDTO){
		CustomerResponse response = service.updateEmail(id, emailDTO.email());
		return  ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{id}")
	public  ResponseEntity deleteCustomer(@PathVariable Long id){
		service.deleteCustomer(id);
		return  ResponseEntity.noContent().build();
	}

}
