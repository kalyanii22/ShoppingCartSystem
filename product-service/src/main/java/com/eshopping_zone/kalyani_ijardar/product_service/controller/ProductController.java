package com.eshopping_zone.kalyani_ijardar.product_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping_zone.kalyani_ijardar.product_service.model.Product;
import com.eshopping_zone.kalyani_ijardar.product_service.service.ProductService;


@RestController
@RequestMapping("/eshoppingzone/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProducts")
	public void addProducts(@RequestBody Product product) {
		
		service.addProducts(product);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		
		return service.getAllProducts();
	}
	
	@GetMapping("/getProductById/{productId}")
	public Optional<Product> getProductById(@PathVariable int productId) {
		
		return service.getProductById(productId);
	}
	
	@GetMapping("/getProductByName/{productName}")
	public Optional<Product> getProductByName(@PathVariable String productName) {
		
		return service.getProductByName(productName);
	}
	
	@PutMapping("/updateProducts/{productId}")
	public Product updateProducts(@PathVariable int productId,@RequestBody Product product) {
		
		return service.updateProducts(productId, product);
	}
	
	@DeleteMapping("/deleteProductById/{productId}")
	public void deleteProductById(@PathVariable int productId) {
		
		service.deleteProductById(productId);
	}
	
	@GetMapping("/getProductByCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable String category) {
		
		return service.getProductByCategory(category);
	}
	
	@GetMapping("/getProductByType/{productType}")
	public List<Product> getProductByType(@PathVariable String productType) {
		
		return service.getProductByType(productType);
	}

}
