package com.pm.servicecatalogservice.mapper;

import com.pm.servicecatalogservice.dto.CategoryDTO;
import com.pm.servicecatalogservice.model.Category;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getName());
    }

    public static Category toModel(CategoryDTO categoryDTO) {
        Category model = new Category();
        model.setName(categoryDTO.getName().toLowerCase());

        return model;
    }
}
