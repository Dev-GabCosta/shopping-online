package com.online.shopping.dtos;

public record ProductRequest (
		String name,
		Integer stock,
		Double price
){
}
