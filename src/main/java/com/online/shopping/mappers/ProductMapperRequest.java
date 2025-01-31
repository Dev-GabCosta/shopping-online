package com.online.shopping.mappers;

import com.online.shopping.dtos.ProductRequest;
import com.online.shopping.models.Product;

public class ProductMapperRequest implements GenericMapper<Product, ProductRequest> {

	@Override
	public Product map(ProductRequest request) {
		return new Product(
				request.name(),
				request.stock(),
				request.price()
		);
	}

}
