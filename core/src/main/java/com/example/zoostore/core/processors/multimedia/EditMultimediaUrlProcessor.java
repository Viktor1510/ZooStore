package com.example.zoostore.core.processors.multimedia;

import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaResponse;
import com.example.zoostore.core.exception_handler.MultiMediaException;
import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaUrlOperation;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class EditMultimediaUrlProcessor implements EditMultimediaUrlOperation {
    private final MultimediaRepository multimediaRepository;
    @Override
    public EditMultimediaResponse process(EditMultimediaRequest request) {
        Optional<Multimedia> multimediaOptional=multimediaRepository.findById(request.getMultimediaId());
        if (multimediaOptional.isPresent()){
            Multimedia existingMultimedia= multimediaOptional.get();
            existingMultimedia.setUrl(request.getUrl());
            return EditMultimediaResponse.builder()
                    .multimediaId(existingMultimedia.getMultimediaId())
                    .url(existingMultimedia.getUrl())
                    .itemId(existingMultimedia.getItem().getItemId()).build();
        }
        throw new MultiMediaException();
    }
}
