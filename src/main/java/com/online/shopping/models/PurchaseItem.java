package com.online.shopping.models;

import jakarta.persistence.*;

@Entity
public class PurchaseItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	@ManyToOne
	private  Product product;
	@Column(nullable = false)
	private Integer quantity;

	public PurchaseItem() {
	}

	public PurchaseItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
