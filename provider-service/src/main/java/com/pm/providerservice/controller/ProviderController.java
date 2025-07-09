package com.pm.providerservice.controller;

import com.pm.providerservice.dto.ProviderRequestDTO;
import com.pm.providerservice.dto.ProviderResponseDTO;
import com.pm.providerservice.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    private ProviderService providerService;

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
    public ResponseEntity<ProviderResponseDTO> addProvider(@RequestBody ProviderRequestDTO providerRequestDTO) {
        ProviderResponseDTO provider = providerService.addProvider(providerRequestDTO);

        return ResponseEntity.ok(provider);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderResponseDTO> getProviderById(@PathVariable String id) {
        ProviderResponseDTO provider = providerService.getProvider(id);

        return ResponseEntity.ok(provider);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProviderResponseDTO> updateProvider(@PathVariable String id,
                                                              @RequestBody ProviderRequestDTO providerRequestDTO) {

        ProviderResponseDTO provider = providerService.updateProvider(id, providerRequestDTO);

        return ResponseEntity.ok(provider);
    }
}
