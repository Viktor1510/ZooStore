package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.createItem.CreateItemRequest;
import com.example.zoostore.api.operations.item.createItem.CreateItemResponse;
import com.example.zoostore.api.operations.item.createItem.CreateItemOperation;
import com.example.zoostore.core.processors.tag.GetAllTagsIdsProcessor;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.core.processors.multimedia.GetAllMultimediaIdsProcessor;
import com.example.zoostore.persistence.repositories.ItemRepository;
import com.example.zoostore.persistence.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateItemProcessor implements CreateItemOperation {
    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;
    private final GetAllTagsIdsProcessor tagsProcessor;
    private final GetAllMultimediaIdsProcessor multimediaIdsProcessor;



    @Override
    public CreateItemResponse process(CreateItemRequest request) {
        Optional<Vendor> vendor=vendorRepository.findById(UUID.fromString(request.getVendorId()));
        List<Multimedia> multimedia=multimediaIdsProcessor.getAllMultimediaIds(request.getMultimediaIds());
        List<Tag> tags=tagsProcessor.getAllTagIds(request.getTagIds());
        Item item=Item.builder()
                .description(request.getDescription())
                .multimedia(Set.of(multimedia.toArray(Multimedia[]::new)))
                .vendor(vendor.get())
                .tags(Set.of(tags.toArray(Tag[]::new)))
                .title(request.getTitle())
                .build();
        itemRepository.save(item);

        return CreateItemResponse.builder()
                .id(item.getItemId().toString())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getVendorId().toString())
                .multimediaIds(item.getMultimedia().stream().map(Multimedia::getMultimediaId).map(UUID::toString).toArray(String[]::new))
                .tagIds(item.getTags().stream().map(Tag::getTagId).map(UUID::toString).toArray(String[]::new))
                .build();
    }
}
