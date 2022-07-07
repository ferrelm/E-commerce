package com.example.demo.accessingdatajpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  // List<Products> findByName(String name);

  List<Product> getProductBycategoryId(Long categoryId);

  List<Product> getProductsBycategoryId(Optional<Long> categoryId);

  List<Product> findBynameContaining(Optional<String> term);

}