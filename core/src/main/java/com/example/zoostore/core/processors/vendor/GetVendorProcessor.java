package com.example.zoostore.core.processors.vendor;

import com.example.zoostore.api.operations.vendor.getvendor.GetVendorRequest;
import com.example.zoostore.api.operations.vendor.getvendor.GetVendorResponse;
import com.example.zoostore.core.exception_handler.VendorException;
import com.example.zoostore.api.operations.vendor.getvendor.GetVendorOperation;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetVendorProcessor implements GetVendorOperation {
    private final VendorRepository vendorRepository;
    @Override
    public GetVendorResponse process(GetVendorRequest request) {

        Optional<Vendor> existingVendorOptional = vendorRepository.findById(UUID.fromString(request.getId()));
        if(existingVendorOptional.isPresent()){
            Vendor existingVendor = existingVendorOptional.get();
            return  GetVendorResponse.builder().id(existingVendor.getVendorId()).name(existingVendor.getName()).build();
        }
        throw new VendorException();
    }
}
