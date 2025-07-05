package com.pm.servicecatalogservice.mapper;

import com.pm.servicecatalogservice.dto.CategoryResponseDTO;
import com.pm.servicecatalogservice.model.ServiceCategory;

public class CategoryMapper {
    public static CategoryResponseDTO toDTO(ServiceCategory serviceCategory) {
        return new CategoryResponseDTO(serviceCategory.getName());
    }
}
