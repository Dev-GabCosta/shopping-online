package com.online.shopping.mappers;

import com.online.shopping.dtos.ProductRequest;
import com.online.shopping.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperRequest implements GenericMapper<ProductRequest, Product> {

	@Override
	public Product map(ProductRequest request) {
		return new Product(
				request.name(),
				request.stock(),
				request.price()
		);
	}

}
