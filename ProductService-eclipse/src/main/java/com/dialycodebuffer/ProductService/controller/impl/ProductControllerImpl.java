package com.dialycodebuffer.ProductService.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*import com.dialycodebuffer.ProductService.controller.ProductController;*/
import com.dialycodebuffer.ProductService.dto.ProductDTO;
import com.dialycodebuffer.ProductService.entity.Product;
import com.dialycodebuffer.ProductService.exception.ProductCustomException;
import com.dialycodebuffer.ProductService.mapper.ProductMapper;
import com.dialycodebuffer.ProductService.service.ProductService;

@RequestMapping("/api/product")
@RestController
public class ProductControllerImpl /* implements ProductController */ {
	private final ProductService productService;
	private final ProductMapper productMapper;

	public ProductControllerImpl(ProductService productService, ProductMapper productMapper) {
		this.productService = productService;
		this.productMapper = productMapper;
	}

	/* @Override */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDTO save(@RequestBody ProductDTO productDTO) {
		Product product = productMapper.asEntity(productDTO);
		return productMapper.asDTO(productService.save(product));
	}

	/* @Override */
	@GetMapping("/{id}")
	public ProductDTO findById(@PathVariable("id") long id) {
		Product product = productService.findById(id).orElseThrow(
				() -> new ProductCustomException("Product with id :" + id + " not found", "PRODUCT_NOT_FOUND"));
		return productMapper.asDTO(product);
	}

	/* @Override */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		productService.deleteById(id);
	}

	/* @Override */
	@GetMapping
	public List<ProductDTO> list() {
		return productMapper.asDTOList(productService.findAll());
	}

	/* @Override */
	/*
	 * @GetMapping("/page-query") public Page<ProductDTO> pageQuery(Pageable
	 * pageable) { Page<Product> productPage = productService.findAll(pageable);
	 * List<ProductDTO> dtoList = productPage .stream()
	 * .map(productMapper::asDTO).collect(Collectors.toList()); return new
	 * PageImpl<>(dtoList, pageable, productPage.getTotalElements()); }
	 */
	/* @Override */
	@PutMapping("/{id}")
	public ProductDTO update(@RequestBody ProductDTO productDTO, @PathVariable("id") long id) {
		Product product = productMapper.asEntity(productDTO);
		return productMapper.asDTO(productService.update(product, id));
	}

	@PutMapping("/reduceProductQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId,
			@RequestParam("quantity") long quantity) {
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<>(HttpStatus.OK);

	}
}