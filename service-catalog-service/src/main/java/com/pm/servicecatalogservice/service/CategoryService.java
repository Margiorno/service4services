package com.pm.servicecatalogservice.service;

import com.pm.servicecatalogservice.dto.CategoryDTO;
import com.pm.servicecatalogservice.exception.InvalidCategoryException;
import com.pm.servicecatalogservice.mapper.CategoryMapper;
import com.pm.servicecatalogservice.model.Category;
import com.pm.servicecatalogservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        return StreamSupport.stream(categories.spliterator(), false).map(CategoryMapper::toDTO).toList();
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {

        if (categoryDTO.getName().isEmpty())
            throw new InvalidCategoryException("Category name cant be empty");

        if (categoryRepository.existsByNameIgnoreCase(categoryDTO.getName()))
            throw new InvalidCategoryException("This category already exists " + categoryDTO.getName());

        Category model = categoryRepository.save(CategoryMapper.toModel(categoryDTO));
        return CategoryMapper.toDTO(model);
    }

    public Category getByName(String name) {
        if (!categoryRepository.existsByNameIgnoreCase(name))
            throw new InvalidCategoryException("This category does not exist " + name);

        return categoryRepository.findByNameIgnoreCase(name);
    }
}
