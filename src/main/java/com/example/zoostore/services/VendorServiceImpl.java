package com.example.zoostore.services;


import com.example.zoostore.Data.request.vendor.CreateVendorRequest;
import com.example.zoostore.Data.request.vendor.EditVendorRequest;
import com.example.zoostore.Data.request.vendor.GetVendorRequest;
import com.example.zoostore.Data.response.item.GetAllItemResponse;
import com.example.zoostore.Data.response.vendor.CreateVendorResponse;
import com.example.zoostore.Data.response.vendor.EditVendorResponse;
import com.example.zoostore.Data.response.vendor.GetAllVendorsResponse;
import com.example.zoostore.Data.response.vendor.GetVendorResponse;
import com.example.zoostore.ExceptionHandler.VendorException;
import com.example.zoostore.models.GetAllVendorsSingleItem;
import com.example.zoostore.interfaces.VendorService;
import com.example.zoostore.models.*;
import com.example.zoostore.repositories.ItemRepository;
import com.example.zoostore.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;
    private final ItemRepository itemRepository;

    public VendorServiceImpl(VendorRepository vendorRepository, ItemRepository itemRepository) {
        this.vendorRepository = vendorRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public EditVendorResponse editVendorName(EditVendorRequest request, String name) {
        Optional<Vendor> existingVendorOptional = vendorRepository.findById(UUID.fromString(request.getId()));
        if (existingVendorOptional.isPresent()) {
            Vendor existingVendor = existingVendorOptional.get();
            existingVendor.setName(name);

            Vendor persisted = vendorRepository.save(existingVendor);

            return EditVendorResponse.builder().id(persisted.getVendorId()).name(persisted.getName()).build();
        }
        throw new VendorException();
    }

    @Override
    public GetVendorResponse getVendor(GetVendorRequest request){
        Optional<Vendor> existingVendorOptional = vendorRepository.findById(UUID.fromString(request.getId()));
        if(existingVendorOptional.isPresent()){
            Vendor existingVendor = existingVendorOptional.get();
            return  GetVendorResponse.builder().id(existingVendor.getVendorId()).name(existingVendor.getName()).build();
        }
        throw new VendorException();
    }
    @Override
    public CreateVendorResponse createVendor(CreateVendorRequest request){
       Vendor vendor= Vendor.builder().name(request.getName()).build();
       Vendor persisted=vendorRepository.save(vendor);
       return CreateVendorResponse.builder().id(persisted.getVendorId()).name(persisted.getName()).build();
    }

    @Override
    public GetAllVendorsResponse getAllVendors() {
        List<Vendor> vendors = this.vendorRepository.findAll();
        List<GetAllVendorsSingleItem> vendorsSingleItems=new ArrayList<>();
        for (Vendor vendor : vendors) {
            GetAllVendorsSingleItem mappedItem = MapVendorToSingleItem(vendor);
            vendorsSingleItems.add(mappedItem);
        }
        return GetAllVendorsResponse.builder().vendorResponses(vendorsSingleItems).build();
    }

    @Override
    public GetAllItemResponse getAllItems(GetVendorRequest vendorRequest) {
        Optional<Vendor> vendor=this.vendorRepository.findById(UUID.fromString(vendorRequest.getId()));
        List<Item> allItems=this.itemRepository.findAll();
        List<Item> items=new ArrayList<>();
        for (Item item:allItems) {
            if(item.getVendor().getVendorId().equals(vendor.get().getVendorId()))
            {
                items.add(item);
            }
        }
        List<GetAllItemSingle> getAllItemSingles=new ArrayList<>();

        for(Item item:items){
            GetAllItemSingle mappedItem=MapItemToSingleItem(item);
            getAllItemSingles.add(mappedItem);
        }

        return GetAllItemResponse.builder().responses(getAllItemSingles).build();
    }

     private GetAllItemSingle MapItemToSingleItem(Item item){
        return GetAllItemSingle.builder()
                .itemId(item.getItemId())
                .description(item.getDescription())
                .title(item.getTitle())
                .build();
     }


    private GetAllVendorsSingleItem MapVendorToSingleItem(Vendor vendor){
      return   GetAllVendorsSingleItem.builder().id(vendor.getVendorId().toString()).name(vendor.getName()).build();
    }
}
