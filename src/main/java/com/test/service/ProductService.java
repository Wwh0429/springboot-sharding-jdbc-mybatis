package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.mapper.ProductMapper;
import com.test.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Transactional
	public void createProduct(Product product) {
		productMapper.createProduct(product);
	}

	
	public List<Product> getProduct(){
		
		return productMapper.getProduct();
	}
}
