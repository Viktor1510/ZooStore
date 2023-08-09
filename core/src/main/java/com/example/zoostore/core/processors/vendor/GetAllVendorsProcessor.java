package com.example.zoostore.core.processors.vendor;

import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsRequest;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsResponse;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsOperation;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsSingleItem;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllVendorsProcessor implements GetAllVendorsOperation {
    private final VendorRepository vendorRepository;
    @Override
    public GetAllVendorsResponse process(GetAllVendorsRequest request) {
        List<Vendor> vendors = vendorRepository.findAll();
        List<GetAllVendorsSingleItem> vendorsSingleItems=new ArrayList<>();
        for (Vendor vendor : vendors) {
            GetAllVendorsSingleItem mappedItem = MapVendorToSingleItem(vendor);
            vendorsSingleItems.add(mappedItem);
        }
        return GetAllVendorsResponse.builder().vendorResponses(vendorsSingleItems).build();
    }

    private GetAllVendorsSingleItem MapVendorToSingleItem(Vendor vendor){
        return   GetAllVendorsSingleItem.builder().id(vendor.getVendorId().toString()).name(vendor.getName()).build();
    }
}
