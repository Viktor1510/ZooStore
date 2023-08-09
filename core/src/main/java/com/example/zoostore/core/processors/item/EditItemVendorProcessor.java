package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.edititemvendor.EditItemVendorRequest;
import com.example.zoostore.api.operations.item.edititemvendor.EditItemVendorOperation;
import com.example.zoostore.api.operations.item.edititemvendor.EditItemVendorResponse;
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
public class EditItemVendorProcessor implements EditItemVendorOperation {
    private final ItemRepository itemRepository;
    @Override
    public EditItemVendorResponse process(EditItemVendorRequest request) {
        Optional<Item> itemOptional=itemRepository.findById(UUID.fromString(request.getId()));
        Item item = null;
        if(itemOptional.isPresent()){
            item=Item.builder()
                    .itemId(itemOptional.get().getItemId())
                    .title(itemOptional.get().getTitle())
                    .description(itemOptional.get().getDescription())
                    .vendor(itemOptional.get().getVendor())
                    .multimedia(itemOptional.get().getMultimedia())
                    .tags(itemOptional.get().getTags())
                    .build();
            itemRepository.save(item);
        }

        assert item != null;
        return getEditItemResponse(item);

    }
    private EditItemVendorResponse getEditItemResponse(Item item) {
        return EditItemVendorResponse.builder()
                .id(item.getItemId())
                .title(item.getTitle())
                .vendorId(item.getVendor().getVendorId().toString())
                .description(item.getDescription())
                .multimediaIds(item.getMultimedia()
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
}
