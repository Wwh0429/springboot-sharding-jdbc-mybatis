package com.test.mapper;

import java.util.List;

import com.test.model.Product;

public interface ProductMapper {
	
	public void createProduct(Product product);

	List<Product> getProduct();
}
