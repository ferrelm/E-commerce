package com.example.demo.accessingdatajpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.MyResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product API", description = "manage and search products")
@RestController
@SecurityRequirement(name = "basicAuth")
@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService ProductService;

    @PostMapping
    @Operation(summary = "Add product")
    public ResponseEntity<ResponseEntity<Object>> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductService.createProduct(product));
    }

    @PatchMapping("/{productId}")
    @Operation(summary = "Update product")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product)
            throws Exception {
        return ProductService.updateProduct(productId, product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{productId}")
    @Operation(summary = "Mark a product as inactive")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long productId) throws Exception {
        return ProductService.deleteProduct(productId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/id/{productId}")
    @Operation(summary = "(really) Delete a product")
    public Boolean deleteProductById(@PathVariable Long productId) {
        return ProductService.deleteProductById(productId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/all")
    @Operation(summary = "Delete all product")
    public Boolean deleteAll() {
        return ProductService.deleteAll();
    }

    @GetMapping("/{productId}")
    @Operation(summary = "Get a product")
    public Product getProduct(@PathVariable Long productId) {
        return ProductService.getProduct(productId);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all products")
    public List<Product> findAll() {
        return ProductService.findAll();
    }

    @GetMapping
    @Operation(summary = "Get a product by optional categoryId")
    public List<Product> findAll(@RequestParam Optional<Long> categoryId, @RequestParam Optional<Long> term) {
        return ProductService.getProductsBycategoryId(categoryId);
    }

    @GetMapping("/category/{categoryId}")
    @Operation(summary = "Get a product by categoryId")
    public List<Product> getProductBycategoryId(@PathVariable Long categoryId) {
        return ProductService.getProductBycategoryId(categoryId);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ MyResourceNotFoundException.class, NoSuchElementException.class })
    public void handleNotFound(Exception ex, HttpServletRequest req) {
        System.out.println("URL: " + req.getRequestURI());
        System.out.println("Message: " + ex.getMessage());
    }

}