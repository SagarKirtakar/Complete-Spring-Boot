package com.bookapp.service;

import com.bookapp.dto.CategoryRequestDTO;
import com.bookapp.model.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryRequestDTO requestDTO);

    void updateCategory(CategoryRequestDTO requestDTO);

    void deleteCategory(int categoryId);

    CategoryRequestDTO getById(int categoryId);

    List<CategoryRequestDTO> getAllCategories();
}
