package com.online.shopping.repositories;

import com.online.shopping.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	boolean existsByEmail(String email);
}
