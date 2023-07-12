package com.example.zoostore.services;

import com.example.zoostore.Data.request.multimedia.CreateMultimediaRequest;
import com.example.zoostore.Data.request.multimedia.EditMultimediaRequest;
import com.example.zoostore.Data.request.multimedia.GetMultimediaRequest;
import com.example.zoostore.Data.response.multimedia.CreateMultimediaResponse;
import com.example.zoostore.Data.response.multimedia.EditMultimediaResponse;
import com.example.zoostore.Data.response.multimedia.GetAllMultimediaResponse;
import com.example.zoostore.Data.response.multimedia.GetMultimediaResponse;
import com.example.zoostore.ExceptionHandler.MultiMediaException;
import com.example.zoostore.interfaces.MultiMediaService;
import com.example.zoostore.models.GetAllMultimediaSingleItem;
import com.example.zoostore.models.Multimedia;
import com.example.zoostore.repositories.MultimediaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;;


public class MediaServiceImpl implements MultiMediaService {
    private final MultimediaRepository multimediaRepository;

    public MediaServiceImpl(MultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }

    @Override
    public EditMultimediaResponse editMultimediaUrl(EditMultimediaRequest request, String url) {
        Optional<Multimedia> multimediaOptional=multimediaRepository.findById(request.getMultimediaId());
        if (multimediaOptional.isPresent()){
            Multimedia existingMultimedia= multimediaOptional.get();
            existingMultimedia.setUrl(url);
            return EditMultimediaResponse.builder()
                    .multimediaId(existingMultimedia.getMultimediaId())
                    .url(existingMultimedia.getUrl())
                    .itemId(existingMultimedia.getItem().getItemId()).build();
        }
        throw new MultiMediaException();
    }

    @Override
    public GetMultimediaResponse getMultimedia(GetMultimediaRequest request) {
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

    @Override
    public CreateMultimediaResponse createVendor(CreateMultimediaRequest request) {
        Multimedia multimedia= Multimedia.builder().url(request.getUrl()).build();
        Multimedia persisted=multimediaRepository.save(multimedia);
        return CreateMultimediaResponse.builder()
                .multimediaId(persisted.getMultimediaId()).
                url(persisted.getUrl())
                .build();
    }

    @Override
    public GetAllMultimediaResponse getAllMultimedia() {
        List<Multimedia> multimediaList =this.multimediaRepository.findAll();
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
