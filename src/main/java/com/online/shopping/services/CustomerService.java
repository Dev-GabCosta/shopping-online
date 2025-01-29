package com.online.shopping.services;

import com.online.shopping.dtos.CustomerRequest;
import com.online.shopping.dtos.CustomerResponse;
import com.online.shopping.dtos.UpdateCustomerEmailDTO;
import com.online.shopping.models.Customer;
import com.online.shopping.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
	private final CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public CustomerResponse createCustomer(CustomerRequest request) {
		Customer customer = new Customer(request.name(), request.cpf(), request.email());
		repository.save(customer);
		return new CustomerResponse(customer.getId(), customer.getName(), customer.getCpf(), customer.getEmail());
	}

	public List<CustomerResponse> getAllCustomers() {
		return repository.findAll()
				       .stream()
				       .map(
						       customer -> new CustomerResponse(
								       customer.getId(),
								       customer.getName(),
								       customer.getCpf(),
								       customer.getEmail()
						       )
				       )
				       .collect(Collectors.toList());
	}

}
