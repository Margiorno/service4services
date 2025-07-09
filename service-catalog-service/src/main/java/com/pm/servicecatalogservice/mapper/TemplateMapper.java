package com.pm.servicecatalogservice.mapper;

import com.pm.servicecatalogservice.dto.TemplateRequestDTO;
import com.pm.servicecatalogservice.dto.TemplateResponseDTO;
import com.pm.servicecatalogservice.model.Template;

public class TemplateMapper {
    public static TemplateResponseDTO toDTO(Template template) {
        TemplateResponseDTO templateResponseDTO = new TemplateResponseDTO();
        templateResponseDTO.setId(template.getId().toString());
        templateResponseDTO.setName(template.getServiceName());
        templateResponseDTO.setCategory(template.getServiceCategory().getId().toString());

        return templateResponseDTO;
    }

    public static Template toModel(TemplateRequestDTO templateDTO) {
        Template model = new Template();
        model.setServiceName(templateDTO.getName().toLowerCase());

        return model;
    }
}
