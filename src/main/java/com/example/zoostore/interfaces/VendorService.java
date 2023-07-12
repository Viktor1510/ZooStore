package com.example.zoostore.interfaces;

import com.example.zoostore.Data.request.vendor.CreateVendorRequest;
import com.example.zoostore.Data.request.vendor.EditVendorRequest;
import com.example.zoostore.Data.request.vendor.GetVendorRequest;
import com.example.zoostore.Data.response.item.GetAllItemResponse;
import com.example.zoostore.Data.response.vendor.CreateVendorResponse;
import com.example.zoostore.Data.response.vendor.EditVendorResponse;
import com.example.zoostore.Data.response.vendor.GetAllVendorsResponse;
import com.example.zoostore.Data.response.vendor.GetVendorResponse;



public interface VendorService {

    EditVendorResponse editVendorName(EditVendorRequest request, String name);

    GetVendorResponse getVendor(GetVendorRequest request);

    CreateVendorResponse createVendor(CreateVendorRequest request);

    GetAllVendorsResponse getAllVendors();

    GetAllItemResponse getAllItems(GetVendorRequest vendorRequest);


}
