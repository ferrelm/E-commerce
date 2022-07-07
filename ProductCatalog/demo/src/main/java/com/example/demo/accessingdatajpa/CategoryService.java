package com.example.demo.accessingdatajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.MyResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@SessionScope
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    // List<Categories> list = new ArrayList<>();

    public Category create(Category category) {
        // return repository.save(new Category(category.getName()));
        return repository.save(category);
    }

    public Category patch(Long categoryId, Category categorydto) {
        // Fetch the data from the database
        Category category = repository.findById(categoryId).get();

        category.setName(categorydto.getName());
        repository.save(category);
        try {
            return category;

        } catch (Exception e) {
            throw new MyResourceNotFoundException("Category do not exist");
        }

    }

    public Boolean delete(Long categoryId) {
        repository.deleteById(categoryId);
        return true;
    }
    // throw new MyResourceNotFoundException("CategoriesService.delete");

    public Boolean deleteAll() {
        repository.deleteAll();
        return true;
    }

    public Category getCategory(Long categoryId) throws MyResourceNotFoundException {
        Optional<Category> categoryOptional = repository.findById(categoryId);

        if (categoryOptional.isPresent()) {
            return categoryOptional.get();
        }
        throw new MyResourceNotFoundException("Category do not exist");
    }

    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
        // return list;
    }

}
