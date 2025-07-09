package com.pm.providerservice.repository;

import com.pm.providerservice.model.Provider;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProviderRepository extends CrudRepository<Provider, UUID> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    Provider updateById(UUID id, Provider provider);
}
