package com.pm.servicecatalogservice.service;

import com.pm.servicecatalogservice.dto.CategoryRequestDTO;
import com.pm.servicecatalogservice.dto.TemplateRequestDTO;
import com.pm.servicecatalogservice.dto.TemplateResponseDTO;
import com.pm.servicecatalogservice.exception.InvalidTemplateNameException;
import com.pm.servicecatalogservice.mapper.TemplateMapper;
import com.pm.servicecatalogservice.model.Category;
import com.pm.servicecatalogservice.model.Template;
import com.pm.servicecatalogservice.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class TemplateService {

    private TemplateRepository templateRepository;
    private CategoryService categoryService;

    @Autowired
    public TemplateService(TemplateRepository templateRepository, CategoryService categoryService) {
        this.templateRepository = templateRepository;
        this.categoryService = categoryService;
    }


    public List<TemplateResponseDTO> getAllByCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.getByName(categoryRequestDTO.getName());

        return templateRepository.findByCategory(category).stream().map(TemplateMapper::toDTO).toList();
    }

    public List<TemplateResponseDTO> getAll() {
        Iterable<Template> templates = templateRepository.findAll();
        return StreamSupport.stream(templates.spliterator(), false).map(TemplateMapper::toDTO).toList();
    }

    public TemplateResponseDTO add(TemplateRequestDTO templateDTO) {
        if (templateRepository.existsByServiceNameIgnoreCase(templateDTO.getName()))
            throw new InvalidTemplateNameException("Template with this name already exists");

        Category category = categoryService.getByName(templateDTO.getCategory());

        Template template = TemplateMapper.toModel(templateDTO);
        template.setServiceCategory(category);

        Template saved = templateRepository.save(template);
        return TemplateMapper.toDTO(saved);
    }
}
