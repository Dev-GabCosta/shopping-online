package com.online.shopping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private final String cpf;
	private final List<Product> products;

	public Purchase() {
	}

	public Purchase(String cpf, List<Product> products) {
		this.cpf = cpf;
		this.products = products;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Product> getProducts() {
		return products;
	}
}
