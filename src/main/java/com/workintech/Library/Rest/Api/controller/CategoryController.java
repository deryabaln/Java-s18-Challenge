package com.workintech.Library.Rest.Api.controller;

import com.workintech.Library.Rest.Api.entity.Category;
import com.workintech.Library.Rest.Api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> find() {
        return categoryService.find();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public Category save(@RequestBody Category category) {
        System.out.println(category.getBookList());
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@RequestBody Category category, @PathVariable int id) {
        Category foundCategory = categoryService.findById(id);
        if (foundCategory != null) {
            category.setId(id);
            return categoryService.save(category);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Category delete(@PathVariable int id) {
        Category category = categoryService.findById(id);
        categoryService.delete(category);
        return category;
    }
}
