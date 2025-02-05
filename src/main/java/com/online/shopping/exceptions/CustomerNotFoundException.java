package com.online.shopping.exceptions;

//Adicionar exceção para lidar com cliente não encontrado
public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
