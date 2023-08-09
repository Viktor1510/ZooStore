package com.example.zoostore.core.processors.vendor;

import com.example.zoostore.api.operations.vendor.getvendor.GetVendorRequest;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemResponse;
import com.example.zoostore.api.operations.vendor.getallvendoritems.GetAllIVendorItemsOperation;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemSingle;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repositories.ItemRepository;
import com.example.zoostore.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAllIVendorItemsProcessor implements GetAllIVendorItemsOperation {
    private final VendorRepository vendorRepository;
    private final ItemRepository itemRepository;
    @Override
    public GetAllItemResponse process(GetVendorRequest request) {
        Optional<Vendor> vendor=vendorRepository.findById(UUID.fromString(request.getId()));
        List<Item> allItems=itemRepository.findAll();
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
}
