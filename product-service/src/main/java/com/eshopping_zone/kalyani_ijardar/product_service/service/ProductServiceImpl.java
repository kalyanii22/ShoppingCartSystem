package com.eshopping_zone.kalyani_ijardar.product_service.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopping_zone.kalyani_ijardar.product_service.exception.ProductNotFoundException;
import com.eshopping_zone.kalyani_ijardar.product_service.model.Product;
import com.eshopping_zone.kalyani_ijardar.product_service.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	

    public Product addProducts(Product product) {
    	Random random = new Random();
        int productId = random.nextInt(100000); 

        product.setProductId(productId);

        return repo.save(product);
    }

	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		
		Product product = repo.findByProductId(productId);
		return product;
	}

	@Override
	public Optional<Product> getProductByName(String productName) {
		
		Optional<Product> product = repo.findByProductName(productName);
		return product;
	}

	@Override
	public Product updateProducts(int productId,Product newProduct) throws ProductNotFoundException {
		
		Product previousProduct = repo.findById(productId).orElse(null);
		if(previousProduct!=null) {
			newProduct.setProductId(previousProduct.getProductId());
			repo.delete(previousProduct);
			repo.save(newProduct);
			return newProduct;
		} else {
			throw new ProductNotFoundException("Product not found with id: "+productId);
		}
	}

	@Override
	public void deleteProductById(int productId) throws ProductNotFoundException {
		
		Product product = repo.findById(productId).orElse(null);
		if(product!=null) {
			repo.delete(product);	
		} else {
			throw new ProductNotFoundException("Product not found with id: "+productId);
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
