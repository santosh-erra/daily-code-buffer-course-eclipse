package com.dailycodebuffer.orderservice.internal.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PRODUCT-SERVICE/api/product")
public interface ProductService {

	@PutMapping("/reduceProductQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId,
			@RequestParam("quantity") long quantity);

}
