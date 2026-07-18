package com.bookapp.service;

import com.bookapp.dto.CategoryRequestDTO;

public interface CategoryService {

    void addCategory(CategoryRequestDTO requestDTO);

    void updateCategory(CategoryRequestDTO requestDTO);

    void deleteCategory(int categoryId);

    CategoryRequestDTO getById(int categoryId);
}
