package com.online.shopping.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	@Column(nullable = false, unique = true)
	private final String  name;
	@Column(nullable = false)
	private  Integer stock;
	@Column(nullable = false, precision = 6, scale = 2)
	private Double price;

	public Product(Integer stock, Double price, String name) {
		this.stock = stock;
		this.price = price;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getStock() {
		return stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
