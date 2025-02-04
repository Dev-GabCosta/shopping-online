package com.online.shopping.dtos;

import com.online.shopping.models.PurchaseItem;

import java.util.List;

public record PurchaseResponse(
		String cpf,
		List<PurchaseItemResponse> items
) {
}
