package com.online.shopping.exceptions;

//Adiciona exceção para o caso de um email já estar sendo usado
public class UsedEmailException extends RuntimeException {
	public UsedEmailException(String message) {
		super(message);
	}
}
