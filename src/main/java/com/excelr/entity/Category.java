package com.excelr.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Category {

	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	 @Column(nullable = false)
	    private String name;
	    
//	 	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch  = FetchType.LAZY )
//	 	 private Set<Product> products;

	    
	    public Category() {}

	    public Category(String name) {
	        this.name = name;
	    }

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


//		public Set<Product> getProducts() {
//			return products;
//		}
//
//
//		public void setProducts(Set<Product> products) {
//			this.products = products;
//		}
	    
	   
	    
	    
		
	
	    
	    
	
}
