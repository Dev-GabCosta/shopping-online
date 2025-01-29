package com.online.shopping.dtos;

public record CustomerRequest(
		String name,
		String cpf,
		String email
) {
}
