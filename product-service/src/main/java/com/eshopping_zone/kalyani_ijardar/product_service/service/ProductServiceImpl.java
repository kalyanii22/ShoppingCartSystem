package com.eshopping_zone.kalyani_ijardar.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping_zone.kalyani_ijardar.product_service.model.Product;
import com.eshopping_zone.kalyani_ijardar.product_service.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public void addProducts(Product product) {
		
		repo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Product> getProductById(int productId) {
		
		Optional<Product> product = repo.findById(productId);
		return product;
	}

	@Override
	public Optional<Product> getProductByName(String productName) {
		
		Optional<Product> product = repo.findByProductName(productName);
		return product;
	}

	@Override
	public Product updateProducts(int productId,Product newProduct) {
		
		Product previousProduct = repo.findById(productId).orElse(null);
		if(previousProduct!=null) {
			newProduct.setProductId(previousProduct.getProductId());
			repo.delete(previousProduct);
			repo.save(newProduct);
			return newProduct;
		}
		return null;
	}

	@Override
	public void deleteProductById(int productId) {
		
		Product product = repo.findById(productId).orElse(null);
		if(product!=null) {
			repo.delete(product);
			
		}
		
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		
		List<Product> products = repo.findByCategory(category);
		return products;
	}

	@Override
	public List<Product> getProductByType(String productType) {
		
		List<Product> products = repo.findByProductType(productType);
		return products;
	}
	
	

}
