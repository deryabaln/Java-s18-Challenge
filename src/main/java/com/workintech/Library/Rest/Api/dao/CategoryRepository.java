package com.workintech.Library.Rest.Api.dao;

import com.workintech.Library.Rest.Api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Integer> {
}
