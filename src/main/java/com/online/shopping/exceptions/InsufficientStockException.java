package com.online.shopping.exceptions;

//Adicionar exceção para lidar com estoque insuficiente
public class InsufficientStockException extends RuntimeException {

	public InsufficientStockException(String message) {
		super(message);
	}
}
