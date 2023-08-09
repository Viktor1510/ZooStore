package com.example.zoostore.controllers;




import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaOperation;
import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaUrlOperation;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaOperation;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.getmultimedia.GetMultimediaOperation;
import com.example.zoostore.api.operations.multimedia.getmultimedia.GetMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.getmultimedia.GetMultimediaResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path="/multimedia")
@RequiredArgsConstructor
public class MediaController {
private final CreateMultimediaOperation creatMultimedia;
private final EditMultimediaUrlOperation editMultimediaUrl;
private final GetAllMultimediaOperation  getAllMultimedia;
private final GetMultimediaOperation getMultimedia;
@Operation(description = "", summary = "")
@GetMapping(path="/moreMultimedia")
    public ResponseEntity<GetAllMultimediaResponse> getAllMultimedia(){
    return ResponseEntity.ok(this.getAllMultimedia.process(new GetAllMultimediaRequest()));
}

@PostMapping(path="/multimedia")
    public ResponseEntity<CreateMultimediaResponse> createMultimedia(@RequestBody CreateMultimediaRequest request){
    return ResponseEntity.ok(this.creatMultimedia.process(request));
}

@PutMapping(path="/multimedia")
    public ResponseEntity<EditMultimediaResponse> editMultimedia(@RequestBody EditMultimediaRequest request){
    return ResponseEntity.ok(this.editMultimediaUrl.process(request));
}

@GetMapping(path="/multimedia/{id}")
    public ResponseEntity<GetMultimediaResponse> getMultimedia(@PathVariable String id){
    return ResponseEntity.ok(this.getMultimedia.process(GetMultimediaRequest.builder().multimediaId(UUID.fromString(id)).build()));
}

}
