package com.pm.providerservice.service;

import com.pm.providerservice.dto.ProviderRequestDTO;
import com.pm.providerservice.dto.ProviderResponseDTO;
import com.pm.providerservice.exception.InvalidEmailException;
import com.pm.providerservice.exception.InvalidPhoneNumberException;
import com.pm.providerservice.mapper.ProviderMapper;
import com.pm.providerservice.model.Provider;
import com.pm.providerservice.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<ProviderResponseDTO> getProviders() {
        Iterable<Provider> providers = providerRepository.findAll();

        return StreamSupport.stream(providers.spliterator(), false).map(ProviderMapper::toDTO).toList();
    }

    public ProviderResponseDTO addProvider(ProviderRequestDTO providerRequestDTO) {
        if (providerRepository.existsByEmail(providerRequestDTO.getEmail())) {
            throw new InvalidEmailException("Provider with this email already exists: " + providerRequestDTO.getEmail());
        }

        if (providerRepository.existsByPhone(providerRequestDTO.getPhone())) {
            throw new InvalidPhoneNumberException("Provider with this phone number already exists: " + providerRequestDTO.getPhone());
        }

        Provider model = ProviderMapper.toModel(providerRequestDTO);
        Provider savedProvider = providerRepository.save(model);

        return ProviderMapper.toDTO(savedProvider);
    }

    public ProviderResponseDTO getProvider(String id) {
        UUID uuid = UUID.fromString(id);
        Provider provider = providerRepository.findById(uuid)
                .orElseThrow(()-> new ProviderNotFoundException("Provider with this id does not exist: " + id));

        return ProviderMapper.toDTO(provider);
    }

    public ProviderResponseDTO patchProvider(String id, ProviderRequestDTO providerRequestDTO) {
        UUID uuid = UUID.fromString(id);

        Provider provider = providerRepository.findById(uuid)
                .orElseThrow(()-> new ProviderNotFoundException("Provider with this email does not exist: " + id));

        if(providerRequestDTO.getName() != null)
            provider.setName(providerRequestDTO.getName());

        if(providerRequestDTO.getPhone() != null)
            provider.setPhone(providerRequestDTO.getPhone());

        if(providerRequestDTO.getEmail() != null)
            provider.setEmail(providerRequestDTO.getEmail());

        if(providerRequestDTO.getAddress() != null)
            provider.setAddress(providerRequestDTO.getAddress());

        Provider savedProvider = providerRepository.save(provider);
        return ProviderMapper.toDTO(savedProvider);
    }

    public void deleteProvider(String id) {
        UUID uuid = UUID.fromString(id);

        providerRepository.delete(
                providerRepository.findById(uuid)
                        .orElseThrow(()->new ProviderNotFoundException("Provider with this id does not exist: " + id)));
    }
}
