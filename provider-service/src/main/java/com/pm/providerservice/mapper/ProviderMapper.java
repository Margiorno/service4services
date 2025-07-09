package com.pm.providerservice.mapper;

import com.pm.providerservice.dto.ProviderRequestDTO;
import com.pm.providerservice.dto.ProviderResponseDTO;
import com.pm.providerservice.model.Provider;

import java.time.LocalDateTime;

public class ProviderMapper {
    public static ProviderResponseDTO toDTO(Provider provider) {
        ProviderResponseDTO providerResponseDTO = new ProviderResponseDTO();
        providerResponseDTO.setId(provider.getId().toString());
        providerResponseDTO.setAddress(provider.getAddress());
        providerResponseDTO.setEmail(provider.getEmail());
        providerResponseDTO.setName(provider.getName());
        providerResponseDTO.setPhone(provider.getPhone());

        return providerResponseDTO;
    }

    public static Provider toModel(ProviderRequestDTO providerRequestDTO) {
        Provider provider = new Provider();
        provider.setAddress(providerRequestDTO.getAddress());
        provider.setEmail(providerRequestDTO.getEmail());
        provider.setName(providerRequestDTO.getName());
        provider.setPhone(providerRequestDTO.getPhone());
        provider.setCreatedAt(LocalDateTime.now());
        return provider;
    }
}
