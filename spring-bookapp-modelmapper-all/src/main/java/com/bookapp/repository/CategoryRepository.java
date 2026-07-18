package com.bookapp.repository;

import com.bookapp.dto.CategoryRequestDTO;
import com.bookapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    CategoryRequestDTO getById(int categoryId);

}
