package com.pm.servicecatalogservice.repository;

import com.pm.servicecatalogservice.model.Category;
import com.pm.servicecatalogservice.model.Template;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TemplateRepository extends CrudRepository<Template, UUID> {
    List<Template> findByCategory(Category category);
    boolean existsByServiceNameIgnoreCase(String serviceName);
}
