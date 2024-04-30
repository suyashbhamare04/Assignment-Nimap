package com.excelr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.Service.ProductService;
import com.excelr.entity.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
		
//	@GetMapping
//	 public List<Product> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Product> categoryPage = productService.getAllProducts(pageable);
//        return categoryPage.getContent();
//    }
	
	 @GetMapping("pagination/{offset}/{pagesize}")
	    public List<Product> getAllproducts(@PathVariable int offset,@PathVariable int pagesize) {
		 Page<Product> paginationproducts = productService.getAllProducts(offset, pagesize);
			return paginationproducts.getContent();
	        
	    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
	        Product product = productService.getProductById(id);
	        return ResponseEntity.ok(product);
	    }
	 
	 @PostMapping
	 public Product createProduct(@RequestBody Product product) {
	        return productService.createProduct(product);
	    }
	
	 @PutMapping("/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        return productService.updateProduct(id, product);
	    }
	
	 @DeleteMapping("/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
	 
	 
}
