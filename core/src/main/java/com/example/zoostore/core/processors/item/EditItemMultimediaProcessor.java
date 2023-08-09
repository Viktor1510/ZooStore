package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.edititemmultimedia.EditItemMultimedia;
import com.example.zoostore.api.operations.item.edititemmultimedia.EditItemMultimediaResponse;
import com.example.zoostore.core.exception_handler.ItemException;
import com.example.zoostore.api.operations.item.edititemmultimedia.EditItemMultimediaOperation;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.core.processors.multimedia.GetAllMultimediaIdsProcessor;
import com.example.zoostore.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemMultimediaProcessor implements EditItemMultimediaOperation {
    private final ItemRepository itemRepository;
    private final GetAllMultimediaIdsProcessor processor;
    @Override
    public EditItemMultimediaResponse process(EditItemMultimedia request) {
        Optional<Item> itemOptional=itemRepository.findById(UUID.fromString(request.getId()));
        List<Multimedia> multimediaList=processor.getAllMultimediaIds(request.getMultimedia());
        if(itemOptional.isPresent()){
            Item item=itemOptional.get();
            item.setMultimedia(Set.of(multimediaList.toArray(Multimedia[]::new)));
            return getEditItemResponse(item);
        }
        throw new ItemException(UUID.fromString(request.getId()));

    }
    private EditItemMultimediaResponse getEditItemResponse(Item item) {
        return EditItemMultimediaResponse.builder()
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
