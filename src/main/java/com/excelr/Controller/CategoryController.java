package com.excelr.Controller;

import java.util.List;

import org.apache.el.stream.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import com.excelr.Service.CategoryService;
import com.excelr.entity.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	 @GetMapping
	    public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        Page<Category> categoryPage = categoryService.getAllCategories(pageable);
	        return categoryPage.getContent();
	    }
	
	
	 @GetMapping("/{id}")
	    public Category getCategoryById(@PathVariable Long id) {
	        return categoryService.getCategoryById(id);
	    }

	 @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	    }
	 
	 @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        return categoryService.updateCategory(id, category);
	    }
	
	 @DeleteMapping("/{id}")
	    public void deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	    }
	 
	 
	
}
