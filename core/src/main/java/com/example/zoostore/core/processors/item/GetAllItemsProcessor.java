package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.getallitems.GetAllItemsRequest;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemResponse;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemsOperation;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemSingle;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetAllItemsProcessor implements GetAllItemsOperation {
    private final ItemRepository itemRepository;
    @Override
    public GetAllItemResponse process(GetAllItemsRequest request) {
        List<Item> items=itemRepository.findAll();
        List<GetAllItemSingle> itemResponses=new ArrayList<>();
        for (Item item : items) {
            GetAllItemSingle itemSingle=MapItemToSingle(item);
            itemResponses.add(itemSingle);
        }
        return GetAllItemResponse.builder().responses(itemResponses).build();

    }
    private GetAllItemSingle MapItemToSingle(Item item){
        return GetAllItemSingle.builder()
                .itemId(item.getItemId())
                .multimediaIds(
                        item.getMultimedia()
                                .stream().
                                map(Multimedia::getMultimediaId)
                                .map(UUID::toString)
                                .toArray(String[]::new))
                .vendorId(item.getVendor().getVendorId().toString())
                .title(item.getTitle())
                .description(item.getDescription()  )
                .tagIds(item.getTags().stream()
                        .map(Tag::getTagId)
                        .map(UUID::toString)
                        .toArray(String[]::new)).build();
    }
}
