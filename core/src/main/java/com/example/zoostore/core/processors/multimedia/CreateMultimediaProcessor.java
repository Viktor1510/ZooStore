package com.example.zoostore.core.processors.multimedia;

import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaOperation;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateMultimediaProcessor implements CreateMultimediaOperation {
    private final MultimediaRepository multimediaRepository;

    @Override
    public CreateMultimediaResponse process(CreateMultimediaRequest request) {
        Multimedia multimedia= Multimedia.builder().url(request.getUrl()).build();
        Multimedia persisted=multimediaRepository.save(multimedia);
        return CreateMultimediaResponse.builder()
                .multimediaId(persisted.getMultimediaId()).
                url(persisted.getUrl())
                .build();
    }
}
