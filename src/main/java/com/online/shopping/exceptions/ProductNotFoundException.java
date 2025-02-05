package com.online.shopping.exceptions;

//Adicionar exceção para o caso de um produto não ser encontrado
public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String message) {
		super(message);
	}
}
