package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.edititemdescription.EditDescriptionItem;
import com.example.zoostore.api.operations.item.edititemdescription.EditItemDescriptionResponse;
import com.example.zoostore.core.exception_handler.ItemException;
import com.example.zoostore.api.operations.item.edititemdescription.EditItemDescriptionOperation;
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
public class EditItemDescriptionProcessor implements EditItemDescriptionOperation {
   private final ItemRepository itemRepository;
    @Override
    public EditItemDescriptionResponse process(EditDescriptionItem request) {
        Optional<Item> itemOptional=itemRepository.findById(UUID.fromString(request.getId()));
        if(itemOptional.isPresent())
        {
            Item item=itemOptional.get();
            item.setDescription(request.getDescription());
            itemRepository.save(item);
            return getEditItemResponse(item);
        }
        throw new ItemException(UUID.fromString(request.getId()));
    }
    private EditItemDescriptionResponse getEditItemResponse(Item item) {
        return EditItemDescriptionResponse.builder()
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
