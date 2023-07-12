package com.example.zoostore.interfaces;

import com.example.zoostore.Data.request.multimedia.CreateMultimediaRequest;
import com.example.zoostore.Data.request.multimedia.EditMultimediaRequest;
import com.example.zoostore.Data.request.multimedia.GetMultimediaRequest;
import com.example.zoostore.Data.response.multimedia.CreateMultimediaResponse;
import com.example.zoostore.Data.response.multimedia.EditMultimediaResponse;
import com.example.zoostore.Data.response.multimedia.GetAllMultimediaResponse;
import com.example.zoostore.Data.response.multimedia.GetMultimediaResponse;


public interface MultiMediaService {
    EditMultimediaResponse editMultimediaUrl(EditMultimediaRequest request, String url);

    GetMultimediaResponse getMultimedia(GetMultimediaRequest request);

    CreateMultimediaResponse createVendor(CreateMultimediaRequest request);

    GetAllMultimediaResponse getAllMultimedia();
}
