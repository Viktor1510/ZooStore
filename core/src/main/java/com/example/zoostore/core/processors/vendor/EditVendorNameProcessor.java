package com.example.zoostore.core.processors.vendor;

import com.example.zoostore.api.operations.vendor.editvendor.EditVendorRequest;
import com.example.zoostore.api.operations.vendor.editvendor.EditVendorResponse;
import com.example.zoostore.core.exception_handler.VendorException;
import com.example.zoostore.api.operations.vendor.editvendor.EditVendorNameOperation;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditVendorNameProcessor implements EditVendorNameOperation {
    private final VendorRepository vendorRepository;
    @Override
    public EditVendorResponse process(EditVendorRequest request) {
        Optional<Vendor> existingVendorOptional = vendorRepository.findById(UUID.fromString(request.getId()));
        if (existingVendorOptional.isPresent()) {
            Vendor existingVendor = existingVendorOptional.get();
            existingVendor.setName(request.getName());

            Vendor persisted = vendorRepository.save(existingVendor);

            return EditVendorResponse.builder().id(persisted.getVendorId()).name(persisted.getName()).build();
        }
        throw new VendorException();
    }
}
