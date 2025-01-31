package com.online.shopping.services;

import com.online.shopping.dtos.ProductRequest;
import com.online.shopping.dtos.ProductResponse;
import com.online.shopping.dtos.UpdateProductDTO;
import com.online.shopping.mappers.ProductMapperRequest;
import com.online.shopping.mappers.ProductMapperResponse;
import com.online.shopping.models.Product;
import com.online.shopping.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
	private final ProductRepository repository;
	private final ProductMapperRequest mapperRequest;
	private final ProductMapperResponse mapperResponse;

	public ProductService(ProductRepository repository, ProductMapperRequest mapperRequest, ProductMapperResponse mapperResponse) {
		this.repository = repository;
		this.mapperRequest = mapperRequest;
		this.mapperResponse = mapperResponse;
	}

	public ProductResponse createProduct(ProductRequest request) {
		Product product = new Product(request.name(), request.stock(), request.price());
		repository.save(product);
		return new ProductResponse(product.getId(), product.getName(), product.getStock(), product.getPrice());
	}

	public List<ProductResponse> getAllProducts() {
		return repository.findAll()
				       .stream()
				       .map(
						       product -> new ProductResponse(
								       product.getId(),
								       product.getName(),
								       product.getStock(),
								       product.getPrice()
						       )
				       )
				       .collect(Collectors.toList());
	}

	public ProductResponse getProductById(Long id) {
		Optional<Product> optionalProduct = repository.findById(id);

		if (optionalProduct.isEmpty()) {
			throw new RuntimeException("Produto não encontrado");
		}

		Product product = optionalProduct.get();
		return new ProductResponse(product.getId(), product.getName(), product.getStock(), product.getPrice());
	}

	public void deleteProduct(Long id) {
		repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
		repository.deleteById(id);
	}

	public ProductResponse updateProduct(Long id, UpdateProductDTO updatedProduct) {
		Optional<Product> optionalProduct = repository.findById(id);

		if (optionalProduct.isEmpty()) {
			throw new RuntimeException("Produto não encontrado");
		}

		Product product = optionalProduct.get();
		product.setStock(updatedProduct.stock());
		product.setPrice(updatedProduct.price());
		repository.save(product);
		return mapperResponse.map(product);
	}
}
