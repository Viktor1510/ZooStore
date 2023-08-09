package com.example.zoostore.core.processors.item;

import com.example.zoostore.api.operations.item.getallitems.GetAllItemResponse;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemSingle;
import com.example.zoostore.api.operations.item.getitemsbytag.GetItemsByTagOperation;
import com.example.zoostore.api.operations.item.getitemsbytag.GetItemsByTagRequest;
import com.example.zoostore.api.operations.item.getitemsbytag.GetItemsByTagResponse;
import com.example.zoostore.core.exception_handler.TagException;
import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.ItemRepository;
import com.example.zoostore.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetItemsByTagProcessor implements GetItemsByTagOperation {
    private final ItemRepository itemRepository;
    private final TagRepository tagRepository;
    @Override
    public GetAllItemResponse process(GetItemsByTagRequest request) {
        Tag tag=tagRepository.findById(request.getTagId()).orElseThrow(TagException::new);
        Pageable firstPage= PageRequest.of(request.getPageNumber(), request.getNumberOfItemsPerPage());
        Page<Item> allItems=itemRepository.findAllByisArchivedAndTagsContaining(false,tag,firstPage);


        return GetAllItemResponse.builder()
                .responses(allItems.stream()
                        .map(this::MapItemToSingle)
                        .collect(Collectors.toList()))
                .build();
    }

    private GetAllItemSingle MapItemToSingle(Item item){
        return GetAllItemSingle.builder()
                .itemId(item.getItemId())
                .multimediaIds(
                        item.getMultimedia()
                                .stream().
                                map(Multimedia::getMultimediaId)
                                .map(UUID::toString)
                                .toArray(String[]::new))
                .tagIds(item.getTags().stream()
                        .map(Tag::getTagId)
                        .map(UUID::toString)
                        .toArray(String[]::new)).build();
    }
}
