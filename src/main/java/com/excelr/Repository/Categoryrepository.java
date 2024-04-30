package com.excelr.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Category;


@Repository
public interface Categoryrepository extends JpaRepository<Category, Long> {

	Category save(Optional<Category> category);

	

}
