package com.online.shopping.services;

import com.online.shopping.dtos.PurchaseResponse;
import com.online.shopping.repositories.PurchaseRepository;

public class PurchaseService {
	private  final PurchaseRepository repository;

	public PurchaseService(PurchaseRepository repository) {
		this.repository = repository;
	}

	public PurchaseResponse createPurchase()
}
