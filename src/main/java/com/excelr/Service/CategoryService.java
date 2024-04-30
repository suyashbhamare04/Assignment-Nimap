package com.excelr.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.excelr.Repository.Categoryrepository;
import com.excelr.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private Categoryrepository categoryrepository;
	
	
	
	
//	  public Page<Category> getAllCategories(Pageable pageable) {
//	        return categoryrepository.findAll(pageable);
//	    }
	
	
	public Page<Category> getAllCategories(int offset , int pagesize) {
        return categoryrepository.findAll(PageRequest.of(offset, pagesize));
    }
	
	
	  public Category getCategoryById(Long id) {
	        return categoryrepository.findById(id)
	                .orElseThrow();
	    }
	
	  public Category createCategory(Category category) {
	        return categoryrepository.save(category);
	    }
	 
	 public Category updateCategory(Long id, Category updatedCategory) {
	        Category category = getCategoryById(id);
	        category.setName(updatedCategory.getName());
	        return categoryrepository.save(category);
	    }
	 
//	 public Category updateCategory(Long id, Category updatedCategory) {
//		    Optional<Category> optionalCategory = getCategoryById(id);
//		    
//		    if (optionalCategory.isPresent()) {
//		        Category category = optionalCategory.get();
//		        category.setName(updatedCategory.getName());
//		        
//		        return categoryrepository.save(category);
//		    }else {
//		       
//		        return null;
//		    }
//		}
	 
	 public void deleteCategory(Long id) {
	        Category category = getCategoryById(id);
	        categoryrepository.delete(category);
	    }
	
}
