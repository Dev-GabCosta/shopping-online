package com.online.shopping.mappers;

import com.online.shopping.dtos.ProductResponse;
import com.online.shopping.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperResponse implements GenericMapper<Product, ProductResponse> {

	@Override
	public ProductResponse map(Product product) {

		return new ProductResponse(
				product.getId(),
				product.getName(),
				product.getStock(),
				product.getPrice()
		);
	}

}
