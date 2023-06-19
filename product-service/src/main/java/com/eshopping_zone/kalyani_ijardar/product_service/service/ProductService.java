package com.eshopping_zone.kalyani_ijardar.product_service.service;

import java.util.List;
import java.util.Optional;

import com.eshopping_zone.kalyani_ijardar.product_service.exception.ProductNotFoundException;
import com.eshopping_zone.kalyani_ijardar.product_service.model.Product;


public interface ProductService {
	
	public Product addProducts(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int productId);
	
	public Optional<Product> getProductByName(String productName);
	
	public Product updateProducts(int productId, Product product) throws ProductNotFoundException;
	
	public void deleteProductById(int productId) throws ProductNotFoundException;
	
	public List<Product> getProductByCategory(String category);
	
	public List<Product> getProductByType(String productType);
	

}
