package com.online.shopping.repositories;

import com.online.shopping.models.Customer;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	boolean existsByEmail(String email);

	Optional<Customer> findByCpf(String cpf);
}
