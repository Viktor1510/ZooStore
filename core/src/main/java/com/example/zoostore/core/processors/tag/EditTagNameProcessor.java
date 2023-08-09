package com.example.zoostore.core.processors.tag;

import com.example.zoostore.api.operations.tag.edittag.EditTagRequest;
import com.example.zoostore.api.operations.tag.edittag.EditTagResponse;
import com.example.zoostore.core.exception_handler.TagException;
import com.example.zoostore.api.operations.tag.edittag.EditTagNameOperation;
import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditTagNameProcessor implements EditTagNameOperation {
    private final TagRepository tagRepository;
    @Override
    public EditTagResponse process(EditTagRequest request) {
        Optional<Tag> tagOptional = tagRepository.findById(UUID.fromString(request.getId()));
        if (tagOptional.isPresent()) {
            Tag tag = tagOptional.get();
            tag.setName(request.getName());
            return EditTagResponse.builder()
                    .tagId(tag.getTagId().toString())
                    .name(tag.getName())
                    .build();
        }
        throw new TagException();
    }
}
