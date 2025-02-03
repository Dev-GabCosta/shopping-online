package com.online.shopping.models;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Purchase {
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
