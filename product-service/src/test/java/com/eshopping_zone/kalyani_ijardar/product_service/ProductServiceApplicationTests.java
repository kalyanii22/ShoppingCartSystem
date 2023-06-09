package com.eshopping_zone.kalyani_ijardar.product_service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eshopping_zone.kalyani_ijardar.product_service.model.Product;
import com.eshopping_zone.kalyani_ijardar.product_service.repository.ProductRepository;
import com.eshopping_zone.kalyani_ijardar.product_service.service.ProductService;


@SpringBootTest
class ProductServiceApplicationTests {

	
	
	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepository repo;
	
	@Test
	public void getAllProductsTest() {
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(101,"Men Clothing","Tshirt","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable"));
		products.add(new Product(102,"Women Clothing","Tees","Fashion",4.9,review,450,"Comfy Tshirts","Machine Washable"));
		when(repo.findAll()).thenReturn(products);
		assertEquals(2, service.getAllProducts().size());
	
	}
	
	
	
	
	
	
	

}
