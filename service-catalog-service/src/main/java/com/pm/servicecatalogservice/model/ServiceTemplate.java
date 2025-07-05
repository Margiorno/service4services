package com.pm.servicecatalogservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class ServiceTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(unique = true)
    private String serviceName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ServiceCategory serviceCategory;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull String getServiceName() {
        return serviceName;
    }

    public void setServiceName(@NotNull String serviceName) {
        this.serviceName = serviceName;
    }

    public @NotNull ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(@NotNull ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }
}
