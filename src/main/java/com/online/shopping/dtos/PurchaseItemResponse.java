package com.online.shopping.dtos;

public record PurchaseItemResponse(
		String name,
		Double price,
		Integer quantity
){
}
