package com.example.zoostore.core.processors.vendor;

import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorRequest;
import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorResponse;
import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorOperation;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateVendorProcessor implements CreateVendorOperation {
    private final VendorRepository vendorRepository;
    @Override
    public CreateVendorResponse process(CreateVendorRequest request) {
        Vendor vendor= Vendor.builder().name(request.getName()).build();
        Vendor persisted=vendorRepository.save(vendor);
        return CreateVendorResponse.builder().id(persisted.getVendorId()).name(persisted.getName()).build();
    }
}
