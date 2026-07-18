package com.bookapp.service.impl;

import com.bookapp.dto.CategoryRequestDTO;
import com.bookapp.model.Category;
import com.bookapp.repository.CategoryRepository;
import com.bookapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addCategory(CategoryRequestDTO requestDTO) {
        Category category = modelMapper.map(requestDTO, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(CategoryRequestDTO requestDTO) {
        Category category = modelMapper.map(requestDTO, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public CategoryRequestDTO getById(int categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        return modelMapper.map(category, CategoryRequestDTO.class);
    }

}
