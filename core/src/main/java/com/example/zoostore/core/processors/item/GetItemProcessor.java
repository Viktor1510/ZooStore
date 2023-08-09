package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.getitem.GetItemRequest;
import com.example.zoostore.api.operations.item.getitem.GetItemResponse;
import com.example.zoostore.core.exception_handler.ItemException;
import com.example.zoostore.api.operations.item.getitem.GetItemOperation;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetItemProcessor implements GetItemOperation {
   private final ItemRepository itemRepository;
    @Override
    public GetItemResponse process(GetItemRequest request) {
        Optional<Item> itemOptional=this.itemRepository.findById(request.getId());
        if(itemOptional.isPresent()){
            Item item=itemOptional.get();
            return GetItemResponse.builder()
                    .id(item.getItemId())
                    .title(item.getTitle())
                    .description(item.getDescription())
                    .vendorId(item.getVendor().getVendorId().toString())
                    .multimediaIds(
                            item.getMultimedia()
                                    .stream()
                                    .map(Multimedia::getMultimediaId)
                                    .map(UUID::toString)
                                    .toArray(String[]::new))
                    .tagIds(item.getTags().stream()
                            .map(Tag::getTagId)
                            .map(UUID::toString)
                            .toArray(String[]::new))
                    .build();
        }
        throw new ItemException(request.getId());
    }
}
