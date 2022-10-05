package com.dialycodebuffer.ProductService.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.dialycodebuffer.ProductService.dto.ProductDTO;
import com.dialycodebuffer.ProductService.entity.Product;

@Component
public class ProductMapper {

	public Product asEntity(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);

		return product;
	}

	public ProductDTO asDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		BeanUtils.copyProperties(product, productDTO);
		return productDTO;
	}

	public List<ProductDTO> asDTOList(List<Product> products) {

		List<ProductDTO> productDTOList = new ArrayList<>();
		for (Product prod : products) {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(prod, productDTO);
			productDTOList.add(productDTO);
		}

		return productDTOList;
	}

}
