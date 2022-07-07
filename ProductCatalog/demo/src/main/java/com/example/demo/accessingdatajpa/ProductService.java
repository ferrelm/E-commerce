package com.example.demo.accessingdatajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.demo.MyResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@EnableJpaRepositories
@Service
@SessionScope
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> createProduct(Product product) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
        } catch (Exception e) {
            throw new MyResourceNotFoundException("Server error");

        }
    }

    public ResponseEntity<Product> updateProduct(Long productId, Product product) {
        // Fetch the data from the database
        Optional<Product> productData = productRepository.findById(productId);

        // Product product = productRepository.findById(productId).get();

        if (productData.isPresent()) {
            Product _product = productData.get();

            if (product.getName() != null) {
                _product.setName(product.getName());
            }
            if (product.getDescription() != null) {
                _product.setDescription(product.getDescription());
            }
            if (product.getCategoryId() != null) {
                _product.setCategoryId(product.getCategoryId());
            }
            if (product.getStock() != null) {
                _product.setStock(product.getStock());
            }
            if (product.getPrice() != null) {
                _product.setPrice(product.getPrice());
            }
            if (product.getActive() != null) {
                _product.setActive(product.getActive());
            }

            // System.out.println(_product.getPrice());
            // productRepository.save(_product);
            // return _product;
            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
            // return productRepository.save(_product);
        } else {
            throw new MyResourceNotFoundException("Product not found for this id:" + productId);
        }

    }

    public ResponseEntity<Product> deleteProduct(Long productId) {
        // Fetch the data from the database
        Optional<Product> productData = productRepository.findById(productId);

        // Product product = productRepository.findById(productId).get();

        if (productData.isPresent()) {
            Product _product = productData.get();
            _product.setActive(false);
            // productRepository.save(_product);
            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
            // return productRepository.save(_product);
        } else {
            throw new MyResourceNotFoundException("Product not found for this id:" + productId);
        }

    }

    public Boolean deleteProductById(Long productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        } catch (Exception e) {
            throw new MyResourceNotFoundException("Product not found for this id:" + productId);

        }

    }

    public Boolean deleteAll() {
        productRepository.deleteAll();
        return true;
    }

    public Product getProduct(Long productId) throws MyResourceNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        throw new MyResourceNotFoundException("ProductService.getProduct");
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getProductsBycategoryId(Optional<Long> categoryId) {
        if (categoryId.isEmpty()) {
            return (List<Product>) productRepository.findAll();
        } else {
            // return(List<Product>) productRepository.getProductsBycategoryId(categoryId);
            return (List<Product>) productRepository.getProductsBycategoryId(categoryId);
        }
    }

    public List<Product> getProductBycategoryId(Long categoryId) throws MyResourceNotFoundException {
        return (List<Product>) productRepository.getProductBycategoryId(categoryId);
    }

}