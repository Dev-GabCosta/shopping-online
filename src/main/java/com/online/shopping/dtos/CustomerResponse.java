package com.online.shopping.dtos;

public record CustomerResponse(
		Long id,
		String  name,
		String cpf,
		String email
) {
}
