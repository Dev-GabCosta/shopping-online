package com.online.shopping.mappers;

import com.online.shopping.dtos.ProductResponse;
import com.online.shopping.models.Product;

public class ProductMapperResponse implements GenericMapper<Product, ProductResponse {

	@Override
	public ProductResponse map(Product entity) {

		return new ProductResponse(
				entity.getId(),
				entity.getName(),
				entity.getStock(),
				entity.getPrice()
		);
	}
}
