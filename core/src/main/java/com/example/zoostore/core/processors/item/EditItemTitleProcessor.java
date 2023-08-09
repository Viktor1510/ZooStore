package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.edititemtitle.EditItemTitle;
import com.example.zoostore.api.operations.item.edititemtitle.EditItemTitleResponse;
import com.example.zoostore.core.exception_handler.ItemException;
import com.example.zoostore.api.operations.item.edititemtitle.EditItemTitleOperation;
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
public class EditItemTitleProcessor implements EditItemTitleOperation {
    private final ItemRepository itemRepository;

    @Override
    public EditItemTitleResponse process(EditItemTitle request) {
        Optional<Item> itemOptional=itemRepository.findById(UUID.fromString(request.getId()));
        if(itemOptional.isPresent())
        {
            Item item=itemOptional.get();
            item.setTitle(request.getTitle());
            itemRepository.save(item);
            return getEditItemResponse(item);
        }
        throw new ItemException(UUID.fromString(request.getId()));
    }

    private EditItemTitleResponse getEditItemResponse(Item item) {
        return EditItemTitleResponse.builder()
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
