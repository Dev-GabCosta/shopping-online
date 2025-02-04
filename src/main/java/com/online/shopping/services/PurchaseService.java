package com.online.shopping.services;

import com.online.shopping.dtos.ProductPurchaseRequest;
import com.online.shopping.dtos.PurchaseItemResponse;
import com.online.shopping.dtos.PurchaseRequest;
import com.online.shopping.dtos.PurchaseResponse;
import com.online.shopping.models.Product;
import com.online.shopping.models.Purchase;
import com.online.shopping.models.PurchaseItem;
import com.online.shopping.repositories.ProductRepository;
import com.online.shopping.repositories.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {
	private final ProductRepository productRepository;
	private final PurchaseRepository purchaseRepository;

	public PurchaseService(PurchaseRepository purchaseRepository, ProductRepository productRepository) {
		this.purchaseRepository = purchaseRepository;
		this.productRepository = productRepository;
	}

	public PurchaseResponse createPurchase(PurchaseRequest request) {
		List<PurchaseItem> purchaseItens = new ArrayList<>();

		for (ProductPurchaseRequest productRequest : request.products()) {
			Product product = productRepository.findByName(productRequest.name())
					                  .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + productRequest.name()));

			if (product.getStock() < productRequest.quantity()) {
				throw new RuntimeException("Não há estoque suficiente para fazer essa aquisição");
			}

			product.setStock(product.getStock() - productRequest.quantity());
			productRepository.save(product);
			PurchaseItem item = new PurchaseItem(product, productRequest.quantity());
			purchaseItens.add(item);
		}

		Purchase purchase = new Purchase(request.cpf(), purchaseItens);
		purchaseRepository.save(purchase);

		List<PurchaseItemResponse> itensResponse = purchase.getItens()
				                                           .stream()
				                                           .map(
item    -> new PurchaseItemResponse(
		item.getProduct().getName(),
		item.getProduct().getPrice(),
		item.getQuantity()
)
				                                           ).collect(Collectors.toList());
		return new PurchaseResponse(
				purchase.getCpf(),
				itensResponse
		);
	}

}
