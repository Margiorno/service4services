package com.pm.servicecatalogservice.service;

import com.pm.servicecatalogservice.dto.CategoryDTO;
import com.pm.servicecatalogservice.dto.TemplateDTO;
import com.pm.servicecatalogservice.mapper.TemplateMapper;
import com.pm.servicecatalogservice.model.Category;
import com.pm.servicecatalogservice.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    private TemplateRepository templateRepository;
    private CategoryService categoryService;

    @Autowired
    public TemplateService(TemplateRepository templateRepository, CategoryService categoryService) {
        this.templateRepository = templateRepository;
        this.categoryService = categoryService;
    }


    public List<TemplateDTO> getAllByCategory(CategoryDTO categoryDTO) {
        Category category = categoryService.getByName(categoryDTO.getName());

        return templateRepository.findByCategory(category).stream().map(TemplateMapper::toDTO).toList();
    }
}
