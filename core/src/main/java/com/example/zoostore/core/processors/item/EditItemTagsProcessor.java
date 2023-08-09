package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.edititemtags.EditItemTags;
import com.example.zoostore.api.operations.item.edititemtags.EditItemTagsResponse;
import com.example.zoostore.core.exception_handler.ItemException;
import com.example.zoostore.api.operations.item.edititemtags.EditItemTagsOperation;
import com.example.zoostore.core.processors.tag.GetAllTagsIdsProcessor;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemTagsProcessor implements EditItemTagsOperation {
    private final ItemRepository itemRepository;
    private final GetAllTagsIdsProcessor processor;

    @Override
    public EditItemTagsResponse process(EditItemTags request) {
        Optional<Item> itemOptional=itemRepository.findById(UUID.fromString(request.getId()));
        List<Tag> tagList=processor.getAllTagIds(request.getTagIds());
        if(itemOptional.isPresent()){
            Item item=itemOptional.get();
            item.setTags(Set.of(tagList.toArray(Tag[]::new)));
            return getEditItemResponse(item);
        }
        throw new ItemException(UUID.fromString(request.getId()));
    }

    private EditItemTagsResponse getEditItemResponse(Item item) {
        return EditItemTagsResponse.builder()
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
