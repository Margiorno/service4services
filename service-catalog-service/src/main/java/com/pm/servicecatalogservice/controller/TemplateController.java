package com.pm.servicecatalogservice.controller;

import com.pm.servicecatalogservice.dto.CategoryDTO;
import com.pm.servicecatalogservice.dto.TemplateDTO;
import com.pm.servicecatalogservice.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/templates")
public class TemplateController {

    private TemplateService templateService;

    @Autowired
    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping
    public ResponseEntity<List<TemplateDTO>> getTemplatesByCategory(@RequestBody CategoryDTO category) {
        List<TemplateDTO> templates = templateService.getAllByCategory(category);
        return ResponseEntity.ok(templates);
    }
}
