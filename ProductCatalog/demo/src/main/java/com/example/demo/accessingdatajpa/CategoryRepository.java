package com.example.demo.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  // List<Categories> findByName(String name);

  // Categories findById(Integer categoryId);

}