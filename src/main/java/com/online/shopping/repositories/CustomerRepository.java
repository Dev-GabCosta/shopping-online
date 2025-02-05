package com.online.shopping.repositories;

import com.online.shopping.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	boolean existsByEmail(String email);

	Optional<Customer> findByCpf(String cpf);
}
