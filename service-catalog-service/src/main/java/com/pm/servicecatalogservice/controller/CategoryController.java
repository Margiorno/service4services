package com.pm.servicecatalogservice.controller;

import com.pm.servicecatalogservice.dto.CategoryRequestDTO;
import com.pm.servicecatalogservice.dto.CategoryResponseDTO;
import com.pm.servicecatalogservice.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getCategories() {
        List<CategoryResponseDTO> categories = categoryService.getCategories();

        return ResponseEntity.ok(categories);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryResponseDTO> addCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO){
        CategoryResponseDTO categoryResponseDTO = categoryService.addCategory(categoryRequestDTO);

        return ResponseEntity.ok(categoryResponseDTO);
    }



}
