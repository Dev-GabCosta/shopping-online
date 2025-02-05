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

	@GetMapping("/{cpf}")
	public ResponseEntity<CustomerResponse> getCustomerByCpf(@PathVariable String cpf) {
		CustomerResponse customerDetailes = service.getCustomerByCpf(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(customerDetailes);
	}

	@GetMapping
	public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
		List<CustomerResponse> customers = service.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(customers);
	}

	@PatchMapping("/{cpf}")
	public ResponseEntity<CustomerResponse> updateCustomerEmail(@PathVariable String cpf, @RequestBody UpdateCustomerEmailDTO emailDTO) {
		CustomerResponse response = service.updateEmail(cpf, emailDTO.email());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {
		service.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}

}
