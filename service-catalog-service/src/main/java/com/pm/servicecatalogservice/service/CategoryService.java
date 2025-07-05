package com.pm.servicecatalogservice.service;

import com.pm.servicecatalogservice.dto.CategoryResponseDTO;
import com.pm.servicecatalogservice.mapper.CategoryMapper;
import com.pm.servicecatalogservice.model.ServiceCategory;
import com.pm.servicecatalogservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private CategoryRepository serviceRepository;

    @Autowired
    public CategoryService(CategoryRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<CategoryResponseDTO> getCategories() {
        Iterable<ServiceCategory> categories = serviceRepository.findAll();
        return StreamSupport.stream(categories.spliterator(), false).map(CategoryMapper::toDTO).toList();
    }
}
