package com.eshopping_zone.kalyani_ijardar.product_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshopping_zone.kalyani_ijardar.product_service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Optional<Product> findByProductName(String productName);
	List<Product> findByCategory(String category);
	List<Product> findByProductType(String productType);

}
