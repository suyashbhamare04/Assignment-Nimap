package com.excelr.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.excelr.Repository.Categoryrepository;
import com.excelr.Repository.Productrepository;
import com.excelr.entity.Category;
import com.excelr.entity.Product;

@Service
public class ProductService {
	
	@Autowired
    private Productrepository productRepository;
	
	@Autowired
	private Categoryrepository categoryrepository;
	
	 public Page<Product> getAllProducts(Pageable pageable) {
	        return productRepository.findAll(pageable);
	    }
	 
	 public Product getProductById(Long id) {
	        Optional<Product> optionalProduct = productRepository.findById(id);
	        return optionalProduct.orElseThrow();
	    }
	 
	 public Product createProduct(Product product) {
		    Category category = product.getCategory();
		    // Save the category first if it's not already saved
		    if (category.getId() == null) {
		        category = categoryrepository.save(category);
		    }
		    // Set the category back to the product
		    product.setCategory(category);
		    // Now save the product
		    return productRepository.save(product);
		}
	 
	 public Product updateProduct(Long id, Product updatedProduct) {
	        Product product = getProductById(id);
	        product.setName(updatedProduct.getName());
	        product.setCategory(updatedProduct.getCategory());
	        return productRepository.save(product);
	    }
	 
	 public void deleteProduct(Long id) {
	        Product product = getProductById(id);
	        productRepository.delete(product);
	    }
	 
	 
	 
}
