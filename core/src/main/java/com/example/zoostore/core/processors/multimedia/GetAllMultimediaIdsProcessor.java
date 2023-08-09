package com.example.zoostore.core.processors.multimedia;

import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class GetAllMultimediaIdsProcessor {
    private final MultimediaRepository multimediaRepository;


    public List<Multimedia> getAllMultimediaIds(String[] multimediaIds){
        List<Optional<Multimedia>> multimedia=new ArrayList<>();
        for (String multimediaId : multimediaIds) {
            Optional<Multimedia> byId=multimediaRepository.findById(UUID.fromString(multimediaId));
            multimedia.add(byId);
        }


        List<Multimedia> allMultiMedia=new ArrayList<>();
        for (Optional<Multimedia> allMultimediaId : multimedia) {
            allMultimediaId.ifPresent(allMultiMedia::add);
        }
        return allMultiMedia ;
    }
}
