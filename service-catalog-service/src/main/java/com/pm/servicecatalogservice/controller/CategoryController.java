package com.pm.servicecatalogservice.controller;

import com.pm.servicecatalogservice.dto.CategoryDTO;
import com.pm.servicecatalogservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        List<CategoryDTO> categories = categoryService.getCategories();

        return ResponseEntity.ok(categories);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO categoryResponseDTO = categoryService.addCategory(categoryDTO);

        return ResponseEntity.ok(categoryResponseDTO);
    }



}
