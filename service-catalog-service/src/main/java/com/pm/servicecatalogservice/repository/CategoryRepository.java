package com.pm.servicecatalogservice.repository;

import com.pm.servicecatalogservice.model.ServiceCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<ServiceCategory, UUID> {
    ServiceCategory findByName(String name);
}
