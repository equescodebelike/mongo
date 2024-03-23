package org.example.service;

import org.example.model.entity.Category;
import org.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    // Read
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void clearDatabase() {
        categoryRepository.deleteAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable String id) {
        return categoryRepository.findById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable String id, @RequestBody Category updatedCategory) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(updatedCategory.getName());
        return categoryRepository.save(category);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

    public void populateCategories() {
        List<Category> categories = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Category category = new Category();
            category.setName("Category " + i);
            categories.add(category);
        }

        categoryRepository.saveAll(categories);
    }
}
