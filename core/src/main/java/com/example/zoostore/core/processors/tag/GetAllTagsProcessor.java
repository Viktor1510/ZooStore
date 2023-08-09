package com.example.zoostore.core.processors.tag;

import com.example.zoostore.api.operations.tag.getalltags.GetAllTagRequest;
import com.example.zoostore.api.operations.tag.getalltags.GetAllTagsResponse;
import com.example.zoostore.api.operations.tag.getalltags.GetAllITagsOperation;
import com.example.zoostore.api.operations.tag.getalltags.GetAllTagSingleItem;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GetAllTagsProcessor implements GetAllITagsOperation {
    private final TagRepository tagRepository;
    @Override
    public GetAllTagsResponse process(GetAllTagRequest request) {
        List<Tag> tagList=tagRepository.findAll();
        List<GetAllTagSingleItem> tagResponses=new ArrayList<>();
        for (Tag tag : tagList) {
            GetAllTagSingleItem getAllTagSingleItem=MapTagToSingleItem(tag);
            tagResponses.add(getAllTagSingleItem);
        }

        return GetAllTagsResponse.builder()
                .tagResponses(tagResponses)
                .build();
    }
    private GetAllTagSingleItem MapTagToSingleItem(Tag tag){
        return GetAllTagSingleItem.builder()
                .tagId(tag.getTagId().toString())
                .name(tag.getName())
                .build();
    }
}
