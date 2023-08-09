package com.example.zoostore.controllers;


import com.example.zoostore.api.operations.item.getallitems.GetAllItemResponse;
import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorOperation;
import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorRequest;
import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorResponse;
import com.example.zoostore.api.operations.vendor.editvendor.EditVendorNameOperation;
import com.example.zoostore.api.operations.vendor.editvendor.EditVendorRequest;
import com.example.zoostore.api.operations.vendor.editvendor.EditVendorResponse;
import com.example.zoostore.api.operations.vendor.getallvendoritems.GetAllIVendorItemsOperation;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsOperation;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsRequest;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsResponse;
import com.example.zoostore.api.operations.vendor.getvendor.GetVendorOperation;
import com.example.zoostore.api.operations.vendor.getvendor.GetVendorRequest;
import com.example.zoostore.api.operations.vendor.getvendor.GetVendorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class VendorController {
    private final CreateVendorOperation createVendor;
    private final GetAllVendorsOperation getAllVendors;
    private final EditVendorNameOperation editVendorName;
    private final GetAllIVendorItemsOperation getAllIVendorItems;
    private final GetVendorOperation getVendor;

    @PostMapping(path = "/vendor")
    public ResponseEntity<CreateVendorResponse> createVendor(@RequestBody CreateVendorRequest request) {
        return ResponseEntity.ok(this.createVendor.process(request));
    }

    @PutMapping("/vendor")
    public ResponseEntity<EditVendorResponse> editVendor(@RequestBody EditVendorRequest request) {
        return ResponseEntity.ok(this.editVendorName.process(request));
    }

    @GetMapping(path = "/vendors")
    public ResponseEntity<GetAllVendorsResponse> getAllVendors() {
        return ResponseEntity.ok(this.getAllVendors.process(new GetAllVendorsRequest()));
    }

    @GetMapping(path = "/vendor/items/{id}")
    public ResponseEntity<GetAllItemResponse> getAllVendorItems(@PathVariable String id) {
        return ResponseEntity.ok(this.getAllIVendorItems.process(GetVendorRequest.builder().id(id).build()));
    }

    @GetMapping(path="/vendor/{id}")
    public ResponseEntity<GetVendorResponse> getVendor(@PathVariable String id){
        return ResponseEntity.ok(this.getVendor.process(GetVendorRequest.builder().id(id).build()));
    }
}