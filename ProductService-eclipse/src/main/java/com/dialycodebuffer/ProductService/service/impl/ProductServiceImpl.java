package com.dialycodebuffer.ProductService.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.dialycodebuffer.ProductService.dao.ProductRepository;
import com.dialycodebuffer.ProductService.entity.Product;
import com.dialycodebuffer.ProductService.exception.ProductCustomException;
import com.dialycodebuffer.ProductService.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	private final ProductRepository repository;

	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Product save(Product entity) {
		return repository.save(entity);
	}

	@Override
	public List<Product> save(List<Product> entities) {
		return (List<Product>) repository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) repository.findAll();
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		Page<Product> entityPage = repository.findAll(pageable);
		List<Product> entities = entityPage.getContent();
		return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
	}

	@Override
	public Product update(Product entity, Long id) {
		Optional<Product> optional = findById(id);
		if (optional.isPresent()) {
			return save(entity);
		}
		return null;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		Product product = repository.findById(productId)
				.orElseThrow(() -> new ProductCustomException("Product with id : " + productId + " not found","PRODUCT_NOT_FOUND"));
		long actualQuantity = product.getQuantity();
		if (product.getQuantity() < quantity) {
			throw new ProductCustomException("Insufficent quantity for productId : " + productId,
					"INSUFFICIENT_QUANTITY");
		}
		product.setQuantity(actualQuantity - quantity);
	}
}