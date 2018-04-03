package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.id.ProductIdGenerator;
import com.test.model.Product;
import com.test.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductIdGenerator productIdGenerator;
	
	@RequestMapping(path="/{productName}", method={RequestMethod.POST})
	public String createProduct(@PathVariable("productName") String productName) {
		Product product = new Product();
		product.setProductId(productIdGenerator.generateProductId().intValue());
		product.setProductName(productName);
		productService.createProduct(product);
		return "success";
	}
	
	
	@RequestMapping(path="/getProduct", method={RequestMethod.POST})
	public List<Product> getProduct() {
		
		List<Product> list = productService.getProduct();
		return list;
	}
	
}
