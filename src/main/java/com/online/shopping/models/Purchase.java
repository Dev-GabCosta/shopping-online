package com.online.shopping.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseItem> itens;

	public Purchase() {
	}

	public Purchase(String cpf, List<PurchaseItem> itens) {
		this.cpf = cpf;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public List<PurchaseItem> getItens() {
		return itens;
	}
}
