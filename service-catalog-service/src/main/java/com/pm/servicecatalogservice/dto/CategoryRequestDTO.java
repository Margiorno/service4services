package com.pm.servicecatalogservice.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
