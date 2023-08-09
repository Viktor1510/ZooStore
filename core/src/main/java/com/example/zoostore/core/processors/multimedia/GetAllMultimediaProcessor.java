package com.example.zoostore.core.processors.multimedia;

import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaOperation;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaSingleItem;
import com.example.zoostore.persistence.entities.Multimedia;
import com.example.zoostore.persistence.repositories.MultimediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMultimediaProcessor implements GetAllMultimediaOperation {
    private final MultimediaRepository multimediaRepository;
    @Override
    public GetAllMultimediaResponse process(GetAllMultimediaRequest request) {
        List<Multimedia> multimediaList =multimediaRepository.findAll();
        List<GetAllMultimediaSingleItem> multimediaResponses=new ArrayList<>();
        for (Multimedia multimedia:multimediaList) {
            GetAllMultimediaSingleItem multimediaSingleItem=MapMultimediaToSingleItem(multimedia);
            multimediaResponses.add(multimediaSingleItem);

        }

        return GetAllMultimediaResponse.builder().multimediaResponses(multimediaResponses).build();
    }

    private GetAllMultimediaSingleItem MapMultimediaToSingleItem(Multimedia multimedia){
        return GetAllMultimediaSingleItem.builder()
                .multimediaId(multimedia.getMultimediaId().toString())
                .url(multimedia.getUrl())
                .itemId(multimedia.getItem().getItemId().toString())
                .build();
    }
}
