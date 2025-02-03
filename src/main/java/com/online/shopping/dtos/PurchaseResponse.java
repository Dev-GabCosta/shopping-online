package com.online.shopping.dtos;

public record PurchaseResponse(
		String email,
		List<ProductPurchaseResponse> products
) {
}
