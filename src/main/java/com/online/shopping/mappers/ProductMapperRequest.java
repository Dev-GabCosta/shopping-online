package com.online.shopping.mappers;

import com.online.shopping.dtos.ProductRequest;
import com.online.shopping.models.Product;

public class ProductMapperRequest implements GenericMapper<Product, ProductRequest> {

	@Override
	public ProductRequest map(Product entity) {
		return new ProductRequest(
				entity.getName(),
				entity.getStock(),
				entity.getPrice()
		);
	}

}
