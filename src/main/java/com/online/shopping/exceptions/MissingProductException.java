package com.online.shopping.exceptions;

//Adicionar exceção para lidar com produtos faltantes
public class MissingProductException extends RuntimeException {

	public  MissingProductException(String  message){
		super(message);
	}

}
