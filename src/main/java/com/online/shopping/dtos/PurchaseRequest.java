package com.online.shopping.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record PurchaseRequest(
		@NotNull(message = "CPF é obrigatório")
		@CPF(message = "Insira um CPF válido")
		String cpf,
		@NotEmpty(message = "A lista de produtos não pode estar vazia")
		List<ProductPurchaseRequest> products
) {
}
