package com.pm.servicecatalogservice.controller;

import com.pm.servicecatalogservice.dto.CategoryRequestDTO;
import com.pm.servicecatalogservice.dto.TemplateRequestDTO;
import com.pm.servicecatalogservice.dto.TemplateResponseDTO;
import com.pm.servicecatalogservice.service.TemplateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    private final TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping
    public ResponseEntity<List<TemplateResponseDTO>> getTemplatesByCategory(@Valid @RequestBody CategoryRequestDTO category) {
        List<TemplateResponseDTO> templates = templateService.getAllByCategory(category);
        return ResponseEntity.ok(templates);
    }

    @GetMapping
    public ResponseEntity<List<TemplateResponseDTO>> getAllTemplates() {
        List<TemplateResponseDTO> templates = templateService.getAll();
        return ResponseEntity.ok(templates);
    }

    @PostMapping("/add")
    public ResponseEntity<TemplateResponseDTO> addTemplate(@Valid @RequestBody TemplateRequestDTO template) {
        TemplateResponseDTO newTemplate = templateService.add(template);

        return ResponseEntity.ok(newTemplate);
    }
}
