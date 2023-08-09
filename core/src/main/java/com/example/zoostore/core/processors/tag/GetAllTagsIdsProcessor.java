package com.example.zoostore.core.processors.tag;

import com.example.zoostore.persistence.entities.Tag;
import com.example.zoostore.persistence.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class GetAllTagsIdsProcessor {
    private final TagRepository tagRepository;
    public List<Tag> getAllTagIds(String[] tagIds){
        List<Optional<Tag>> tags=new ArrayList<>();
        for (String tagId : tagIds) {
            Optional<Tag> byId=tagRepository.findById(UUID.fromString(tagId));
            tags.add(byId);
        }


        List<Tag> allTags=new ArrayList<>();
        for (Optional<Tag> tagId : tags) {
            tagId.ifPresent(allTags::add);
        }
        return allTags ;
    }
}
