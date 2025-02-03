package com.online.shopping.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
		@NotNull(message = "O nome do produto é obrigatório")
		String name,
		@NotNull(message = "É obrigatório informar uma quantidade")
		@Min(value = 1,   message = "A quantidade deve ser no mínimo 1")
		Integer quantity
) {
}
