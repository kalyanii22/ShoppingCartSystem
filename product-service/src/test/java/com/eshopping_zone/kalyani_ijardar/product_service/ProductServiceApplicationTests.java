package com.eshopping_zone.kalyani_ijardar.product_service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eshopping_zone.kalyani_ijardar.product_service.exception.ProductNotFoundException;
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
	public void addProductsTest() {
		
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		Product product = new Product(101,"Men Clothing","Tshirt","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable");
		
		when(repo.save(product)).thenReturn(product);

		Product addedProduct = service.addProducts(product);

		assertNotNull(addedProduct);
		assertEquals(product, addedProduct);
	}

	
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
	
	@Test
	public void getProductByIdTest() {
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		Product product = new Product(101,"Men Clothing","Tshirt","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable");
		int productId = 101;

		when(repo.findByProductId(productId)).thenReturn(product);

		Product retrievedProduct = service.getProductById(productId);

		assertNotNull(retrievedProduct);
		assertEquals(product, retrievedProduct);
	}
	
	@Test
	public void getProductByNameTest() {
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		Product product = new Product(101,"Men Clothing","Tshirt","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable");
		String productName = "Tshirt";
		when(repo.findByProductName(productName)).thenReturn(Optional.of(product));

		Optional<Product> retrievedProduct = service.getProductByName(productName);

		assertTrue(retrievedProduct.isPresent());
		assertEquals(productName, retrievedProduct.get().getProductName());
	}
	
	@Test
	public void updateProductTest() throws ProductNotFoundException {
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		int productId = 101;
		Product existingProduct = new Product(101,"Men Clothing","Jeans","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable");
		existingProduct.setProductId(productId);
		

		Product newProduct = new Product(101,"Men Clothing","Tshirt","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable");
		newProduct.setProductId(productId);

		when(repo.findById(productId)).thenReturn(Optional.of(existingProduct));
		when(repo.save(newProduct)).thenReturn(newProduct);

		Product updatedProduct = service.updateProducts(productId, newProduct);

		assertNotNull(updatedProduct);
		assertEquals(updatedProduct, newProduct);

	}
	
	@Test
	public void deleteProductByIdTest() throws ProductNotFoundException {
		
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		Product product = new Product(101,"Men Clothing","Jeans","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable");
		int productId = product.getProductId();
		when(repo.findById(productId)).thenReturn(Optional.of(product));

		service.deleteProductById(productId);

		verify(repo, times(1)).delete(product);
	}
	
	@Test
	public void getProductByCategoryTest() {
		
		String category = "Fashion";
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(101,"Men Clothing","Tshirt","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable"));
		products.add(new Product(102,"Women Clothing","Tees","Fashion",4.9,review,450,"Comfy Tshirts","Machine Washable"));
		when(repo.findByCategory(category)).thenReturn(products);

		List<Product> productList = service.getProductByCategory(category);

		assertNotNull(productList);
		assertEquals(productList.size(), products.size());
	}
	
	@Test
	public void getProductByTypeTest() {
		
		String type = "Men Clothing";
		List<String> review = new ArrayList<>();
		review.add("good");
		review.add("superb");
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(101,"Men Clothing","Tshirt","Fashion",4.3,review,230,"Cotton Tshirts","Machine Washable"));
		products.add(new Product(102,"Men Clothing","Tees","Fashion",4.9,review,450,"Comfy Tshirts","Machine Washable"));
		when(repo.findByProductType(type)).thenReturn(products);

		List<Product> productList = service.getProductByType(type);

		assertNotNull(productList);
		assertEquals(productList.size(), products.size());
	}
	
	
	
	
	
	
	
	

}
