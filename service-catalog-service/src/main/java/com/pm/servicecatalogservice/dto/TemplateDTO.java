package com.pm.servicecatalogservice.dto;

public class TemplateDTO {
    private String name;
    private String category;

    public TemplateDTO(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
