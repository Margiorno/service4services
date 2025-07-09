package com.pm.servicecatalogservice.mapper;

import com.pm.servicecatalogservice.dto.CategoryRequestDTO;
import com.pm.servicecatalogservice.dto.CategoryResponseDTO;
import com.pm.servicecatalogservice.model.Category;

public class CategoryMapper {
    public static CategoryResponseDTO toDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setId(category.getId().toString());
        categoryResponseDTO.setName(category.getName());

        return categoryResponseDTO;
    }

    public static Category toModel(CategoryRequestDTO categoryRequestDTO) {
        Category model = new Category();
        model.setName(categoryRequestDTO.getName().toLowerCase());

        return model;
    }

//    catalog.Category toProtoCategory(Category category) {
//        return catalog.Category.newBuilder()
//                .setId(category.getId().toString())
//                .setName(category.getName())
//                .build();
//    }
}
