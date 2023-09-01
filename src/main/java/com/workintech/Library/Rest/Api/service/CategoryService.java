package com.workintech.Library.Rest.Api.service;

import com.workintech.Library.Rest.Api.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> find();
    Category findById(int id);
    Category save(Category category);
    void delete(Category category);
}
