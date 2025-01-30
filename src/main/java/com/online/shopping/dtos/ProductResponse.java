package com.online.shopping.dtos;

public record ProductResponse(
		Long id,
		String name,
		Integer stock,
		Double price
) {
}
