package com.example.zoostore.core.processors.tag;

import com.example.zoostore.api.operations.tag.createtag.CreateTagRequest;
import com.example.zoostore.api.operations.tag.createtag.CreateTagResponse;
import com.example.zoostore.api.operations.tag.createtag.CreateTagOperation;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTagProcessor implements CreateTagOperation {
    private final TagRepository tagRepository;
    @Override
    public CreateTagResponse process(CreateTagRequest request) {
        Tag tag=Tag.builder()
                .name(request.getName())
                .build();
        tagRepository.save(tag);

        return CreateTagResponse.builder()
                .tagId(tag.getTagId().toString())
                .name(tag.getName())
                .build();
    }
}
