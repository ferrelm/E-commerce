package com.example.demo.accessingdatajpa;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.MyResourceNotFoundException;

@Tag(name = "Category API", description = "manage and search categories")
@RestController
@SecurityRequirement(name = "basicAuth")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService CategoryService;

    @PostMapping("")
    @Operation(summary = "Add category")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryService.create(category));
    }

    @PatchMapping("/{categoryId}")
    @Operation(summary = "Update category")
    public Category patch(@PathVariable Long categoryId, @RequestBody Category category) throws Exception {
        return CategoryService.patch(categoryId, category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a category")
    @DeleteMapping("/{categoryId}")
    public Boolean delete(@PathVariable Long categoryId) {
        return CategoryService.delete(categoryId);
    }

    @Operation(summary = "Delete all categories")
    @DeleteMapping("/all")
    public Boolean deleteAll() {
        return CategoryService.deleteAll();
    }

    @Operation(summary = "List category")
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return CategoryService.getCategory(categoryId);
    }

    @Operation(summary = "List all category")
    @GetMapping
    public List<Category> findAll() {
        return CategoryService.findAll();
    }

}