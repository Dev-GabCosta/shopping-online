package com.online.shopping.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest (
		@NotNull(message = "O nome do produto é obrigatório")
		String name,
		@Positive(message = "O estoque deve ser maior que 0")
		Integer stock,
		@Positive(message = "O preço deve ser maior que 0")
		Double price
){
}
