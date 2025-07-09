package com.pm.providerservice.dto;

import com.pm.providerservice.dto.validators.CreateProviderValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProviderRequestDTO {
    @NotBlank(groups = CreateProviderValidationGroup.class, message = "Name is required")
    private String name;

    @NotBlank(groups = CreateProviderValidationGroup.class, message = "Address is required")
    private String address;

    @NotBlank(groups = CreateProviderValidationGroup.class, message = "Phone Number is required")
    @Pattern(regexp = "\\d{9}", message = "Phone number must be 9 digits")
    private String phone;

    @Email(groups = CreateProviderValidationGroup.class, message = "Invalid email format")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
