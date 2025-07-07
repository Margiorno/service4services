package com.pm.servicecatalogservice.repository;

import com.pm.servicecatalogservice.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {
    boolean existsByNameIgnoreCase(String name);
    Category findByNameIgnoreCase(String name);
}
