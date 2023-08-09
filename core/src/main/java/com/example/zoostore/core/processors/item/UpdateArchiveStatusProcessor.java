package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.updatearchivestatus.UpdateArchiveStatusOperation;
import com.example.zoostore.api.operations.item.updatearchivestatus.UpdateArchiveStatusRequest;
import com.example.zoostore.api.operations.item.updatearchivestatus.UpdateArchiveStatusResponse;
import com.example.zoostore.core.exception_handler.ItemException;
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
public class UpdateArchiveStatusProcessor implements UpdateArchiveStatusOperation {
   private final ItemRepository itemRepository;
    @Override
    public UpdateArchiveStatusResponse process(UpdateArchiveStatusRequest request) {
        Optional<Item> itemOptional = this.itemRepository.findById(UUID.fromString(request.getId()));
        if(itemOptional.isPresent()){
            Item item=itemOptional.get();
            item.setIsArchived(request.getUpdate());
            itemRepository.save(item);
            return getUpdateArchiveStatusResponse(item);
        }

        throw new ItemException(UUID.fromString(request.getId()));
    }

    private UpdateArchiveStatusResponse getUpdateArchiveStatusResponse(Item item){
        return UpdateArchiveStatusResponse.builder()
                .id(item.getItemId())
                .title(item.getTitle())
                .description(item.getDescription())
                .vendorId(item.getVendor().getVendorId())
                .multimedia(item.getMultimedia().stream().map(Multimedia::getMultimediaId).toArray(UUID[]::new))
                .tags(item.getTags().stream().map(Tag::getTagId).toArray(UUID[]::new))
                .build();
    }
}
