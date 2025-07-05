package com.pm.servicecatalogservice.mapper;

import com.pm.servicecatalogservice.dto.CategoryDTO;
import com.pm.servicecatalogservice.model.ServiceCategory;

public class CategoryMapper {
    public static CategoryDTO toDTO(ServiceCategory serviceCategory) {
        return new CategoryDTO(serviceCategory.getName());
    }

    public static ServiceCategory toModel(CategoryDTO categoryDTO) {
        ServiceCategory model = new ServiceCategory();
        model.setName(categoryDTO.getName().toLowerCase());

        return model;
    }
}
