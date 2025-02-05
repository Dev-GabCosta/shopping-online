package com.online.shopping.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerRequest(
		@NotNull(message = "Nome é obrigatório")
		String name,
		@NotNull(message = "CPF é obrigatório")
		@CPF(message = "Insira um CPF válido")
		String cpf,
		@NotNull(message = "O email é obrigatório")
		@Email(message = "O email deve possuir o formato usuario@email.com")
		String email
) {
}
