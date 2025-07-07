package com.pm.servicecatalogservice.mapper;

import com.pm.servicecatalogservice.dto.TemplateDTO;
import com.pm.servicecatalogservice.model.Template;

public class TemplateMapper {
    public static TemplateDTO toDTO(Template template) {
        return new TemplateDTO(template.getServiceName(), template.getServiceCategory().getName());
    }


}
