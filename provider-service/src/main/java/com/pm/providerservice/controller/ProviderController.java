package com.pm.providerservice.controller;

import com.pm.providerservice.dto.ProviderRequestDTO;
import com.pm.providerservice.dto.ProviderResponseDTO;
import com.pm.providerservice.dto.validators.CreateProviderValidationGroup;
import com.pm.providerservice.service.ProviderService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public ResponseEntity<List<ProviderResponseDTO>> getProviders() {
        List<ProviderResponseDTO> providers = providerService.getProviders();

        return ResponseEntity.ok(providers);
    }

    @PostMapping("/add")
    public ResponseEntity<ProviderResponseDTO> addProvider(
            @Validated({Default.class, CreateProviderValidationGroup.class}) @RequestBody ProviderRequestDTO providerRequestDTO) {
        ProviderResponseDTO provider = providerService.addProvider(providerRequestDTO);

        return ResponseEntity.ok(provider);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderResponseDTO> getProviderById(@PathVariable String id) {
        ProviderResponseDTO provider = providerService.getProvider(id);

        return ResponseEntity.ok(provider);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ProviderResponseDTO> patchProvider(@PathVariable String id,
                                                             @Validated({Default.class}) @RequestBody ProviderRequestDTO providerRequestDTO) {

        ProviderResponseDTO provider = providerService.patchProvider(id, providerRequestDTO);

        return ResponseEntity.ok(provider);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable String id) {

        providerService.deleteProvider(id);

        return ResponseEntity.ok().build();
    }
}
