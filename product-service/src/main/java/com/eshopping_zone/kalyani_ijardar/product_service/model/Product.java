package com.eshopping_zone.kalyani_ijardar.product_service.model;

import java.util.List;

//import jakarta.annotation.Nonnull;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	
	@Id
	private String productId;
	
	
	private String productType;
	
	private String productName;
	
	private String category;
	
	private double rating;
	
	private List<String> reviews;
	
	private double price;
	
	private String description;
	
	private String specification;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<String> getReview() {
		return reviews;
	}

	public void setReview(List<String> reviews) {
		this.reviews = reviews;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Product(String productId, String productType, String productName, String category, double rating,
			List<String> reviews, double price, String description, String specification) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.reviews = reviews;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
