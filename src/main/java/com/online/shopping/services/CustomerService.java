package com.online.shopping.services;

import com.online.shopping.dtos.CustomerRequest;
import com.online.shopping.dtos.CustomerResponse;
import com.online.shopping.exceptions.CustomerNotFoundException;
import com.online.shopping.exceptions.UsedEmailException;
import com.online.shopping.models.Customer;
import com.online.shopping.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Adicionar implementação das exceções
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

	public CustomerResponse updateEmail(String cpf, String email) {
		Optional<Customer> optionalCustomer = repository.findByCpf(cpf);

		if (optionalCustomer.isEmpty()) {
			throw new CustomerNotFoundException(showMessage(cpf));
		}

		Customer customer = optionalCustomer.get();

		if (repository.existsByEmail(email)) {
			throw new UsedEmailException("O e-mail já está sendo usado");
		}

		customer.setEmail(email);
		repository.save(customer);
		return new CustomerResponse(customer.getId(), customer.getName(), customer.getCpf(), customer.getEmail());
	}

	public void deleteCustomer(Long id) {
		repository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(showMessage(id)));

		repository.deleteById(id);
	}

	private static String showMessage(Long id) {
		return "Não foi possível encontrar o cliente com o id " + id;
	}

	private String showMessage(String cpf) {
		return "Não foi possível encontrar o cliente com o CPF " + cpf;
	}

}