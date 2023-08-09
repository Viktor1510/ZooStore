package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.getitembyid.GetItemByIdOperation;
import com.example.zoostore.api.operations.item.getitembyid.GetItemByIdRequest;
import com.example.zoostore.api.operations.item.getitembyid.GetItemByIdResponse;
import com.example.zoostore.core.exception_handler.ItemException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class GetItemByIdProcessor implements GetItemByIdOperation {
    private final ItemRepository itemRepository;
    @Override
    public GetItemByIdResponse process(GetItemByIdRequest request) {

        Item item = this.itemRepository.findById(request.getId()).orElseThrow(() -> new ItemException(request.getId()));

        return GetItemByIdResponse.builder()
                .id(item.getItemId())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getVendorId())
                .multimedia(item.getMultimedia().stream().map(Multimedia::getMultimediaId).toArray(UUID[]::new))
                .tags(item.getTags().stream().map(Tag::getTagId).toArray(UUID[]::new))
                .isArchived(item.getIsArchived())
                .build();
    }
}
