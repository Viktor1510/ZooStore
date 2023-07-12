package com.example.zoostore.controllers;


import com.example.zoostore.Data.request.vendor.CreateVendorRequest;

import com.example.zoostore.Data.request.vendor.EditVendorRequest;
import com.example.zoostore.Data.request.vendor.GetVendorRequest;
import com.example.zoostore.Data.request.vendor.VendorNameRequest;
import com.example.zoostore.Data.response.item.GetAllItemResponse;
import com.example.zoostore.Data.response.vendor.CreateVendorResponse;
import com.example.zoostore.Data.response.vendor.EditVendorResponse;
import com.example.zoostore.Data.response.vendor.GetAllVendorsResponse;
import com.example.zoostore.Data.response.vendor.GetVendorResponse;
import com.example.zoostore.interfaces.VendorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/vendors")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping(path="/getAllVendors")
    public ResponseEntity<GetAllVendorsResponse> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());

    }

    @GetMapping(path="/getAllItems")
    public ResponseEntity<GetAllItemResponse> getAllItems(GetVendorRequest request){
        return ResponseEntity.ok(vendorService.getAllItems(request));
    }
    @PatchMapping("/nameChanger")
    public ResponseEntity<EditVendorResponse> editVendorByName(@RequestBody @Valid EditVendorRequest request , @RequestBody VendorNameRequest vendorNameRequest){
        return ResponseEntity.ok(vendorService.editVendorName(request,vendorNameRequest.getName()));
    }

    @GetMapping(path="/getVendor/{vendorId}")
    public ResponseEntity<GetVendorResponse> getVendor(@RequestParam  String vendorId)
    {
        return  ResponseEntity.ok(vendorService.getVendor(new GetVendorRequest(vendorId)));
    }
    @PostMapping(path="/createVendor")
    public ResponseEntity<CreateVendorResponse> addNewVendor(@RequestBody @Valid CreateVendorRequest request){
        return ResponseEntity.ok(vendorService.createVendor(request));
    }


}
