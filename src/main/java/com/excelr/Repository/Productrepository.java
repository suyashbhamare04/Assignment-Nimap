package com.excelr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Product;

@Repository
public interface Productrepository extends JpaRepository<Product, Long> {

}
