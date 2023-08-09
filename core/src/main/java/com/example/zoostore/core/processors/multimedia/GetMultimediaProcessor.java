package com.example.zoostore.core.processors.multimedia;

import com.example.zoostore.api.operations.multimedia.getmultimedia.GetMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.getmultimedia.GetMultimediaResponse;
import com.example.zoostore.core.exception_handler.MultiMediaException;
import com.example.zoostore.api.operations.multimedia.getmultimedia.GetMultimediaOperation;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetMultimediaProcessor implements GetMultimediaOperation {
    private final MultimediaRepository multimediaRepository;
    @Override
    public GetMultimediaResponse process(GetMultimediaRequest request) {
        Optional<Multimedia> existingVendorOptional = multimediaRepository.findById(request.getMultimediaId());
        if(existingVendorOptional.isPresent()){
            Multimedia existingMultimedia=existingVendorOptional.get();
            return GetMultimediaResponse.builder()
                    .multimediaId(existingMultimedia.getMultimediaId())
                    .url(existingMultimedia.getUrl())
                    .itemId(existingMultimedia.getItem().getItemId()).build();
        }
        throw new MultiMediaException();
    }
}
