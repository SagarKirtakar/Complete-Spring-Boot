package com.bookapp.service.impl;

import com.bookapp.dto.CategoryRequestDTO;
import com.bookapp.model.Category;
import com.bookapp.repository.CategoryRepository;
import com.bookapp.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Transactional
    public CategoryRequestDTO getById(int categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("category not found : "+categoryId));
        return modelMapper.map(category, CategoryRequestDTO.class);
    }

    @Override
    @Transactional
    public List<CategoryRequestDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(category -> modelMapper
                        .map(category, CategoryRequestDTO.class)).toList();
    }

}
