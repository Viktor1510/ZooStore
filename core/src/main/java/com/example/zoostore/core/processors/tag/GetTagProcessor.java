package com.example.zoostore.core.processors.tag;

import com.example.zoostore.api.operations.tag.gettag.GetTagRequest;
import com.example.zoostore.api.operations.tag.gettag.GetTagResponse;
import com.example.zoostore.core.exception_handler.TagException;
import com.example.zoostore.api.operations.tag.gettag.GetTagOperation;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class GetTagProcessor implements GetTagOperation {
    private final TagRepository tagRepository;
    @Override
    public GetTagResponse process(GetTagRequest request) {
        Optional<Tag> tagOptional=tagRepository.findById(UUID.fromString(request.getTagId()));
        if (tagOptional.isPresent())
        {
            return GetTagResponse.builder()
                    .tagId(tagOptional.get().getTagId().toString())
                    .name(tagOptional.get().getName())
                    .build();
        }
        throw new TagException();
    }
}
