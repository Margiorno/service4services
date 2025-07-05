package com.pm.servicecatalogservice.controller;

import com.pm.servicecatalogservice.dto.CategoryResponseDTO;
import com.pm.servicecatalogservice.model.ServiceCategory;
import com.pm.servicecatalogservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getCategories() {
        List<CategoryResponseDTO> categories = categoryService.getCategories();

        return ResponseEntity.ok(categories);
    }



}
