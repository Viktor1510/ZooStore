package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.edititem.EditItemOperation;
import com.example.zoostore.api.operations.item.edititem.EditItemRequest;
import com.example.zoostore.api.operations.item.edititem.EditItemResponse;
import com.example.zoostore.core.exception_handler.ItemException;
import com.example.zoostore.core.processors.multimedia.GetAllMultimediaIdsProcessor;
import com.example.zoostore.core.processors.tag.GetAllTagsIdsProcessor;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.entities.Vendor;
import com.example.zoostore.persistence.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditItemProcessor implements EditItemOperation {
    private final ItemRepository itemRepository;

    private final GetAllMultimediaIdsProcessor multimediaIdsProcessor;

    private final GetAllTagsIdsProcessor getAllTagsIdsProcessor;

    @Override
    public EditItemResponse process(EditItemRequest request) {
        Optional<Item> itemOptional=itemRepository.findById(request.getId());
        List<Multimedia> multimediaList=multimediaIdsProcessor.getAllMultimediaIds(request.getMultimediaIds());
        List<Tag> tagList=getAllTagsIdsProcessor.getAllTagIds(request.getTagIds());
        if(itemOptional.isPresent())
        {
            Item item=itemOptional.get();
            item.setDescription(request.getDescription());
            item.setTitle(request.getTitle());
            item.setIsArchived(request.isArchived());
            item.setMultimedia(Set.of(multimediaList.toArray(Multimedia[]::new)));
            item.setTags(Set.of(tagList.toArray(Tag[]::new)));
            itemRepository.save(item);
            return EditItemResponse.builder()
                    .id(item.getItemId())
                    .description(item.getDescription())
                    .title(item.getTitle())
                    .vendorId(item.getVendor().getVendorId().toString())
                    .tagIds(item.getTags().stream().map(Tag::getTagId).map(UUID::toString).toArray(String[]::new))
                    .multimediaIds(item.getMultimedia().stream().map(Multimedia::getMultimediaId).map(UUID::toString).toArray(String[]::new))
                    .build();
        }
        throw new ItemException(request.getId());
    }
}
