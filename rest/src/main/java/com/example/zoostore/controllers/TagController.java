package com.example.zoostore.controllers;


import com.example.zoostore.api.operations.tag.createtag.CreateTagOperation;
import com.example.zoostore.api.operations.tag.createtag.CreateTagRequest;
import com.example.zoostore.api.operations.tag.createtag.CreateTagResponse;
import com.example.zoostore.api.operations.tag.edittag.EditTagNameOperation;
import com.example.zoostore.api.operations.tag.edittag.EditTagRequest;
import com.example.zoostore.api.operations.tag.edittag.EditTagResponse;
import com.example.zoostore.api.operations.tag.getalltags.GetAllITagsOperation;
import com.example.zoostore.api.operations.tag.getalltags.GetAllTagRequest;
import com.example.zoostore.api.operations.tag.getalltags.GetAllTagsResponse;
import com.example.zoostore.api.operations.tag.gettag.GetTagOperation;
import com.example.zoostore.api.operations.tag.gettag.GetTagRequest;
import com.example.zoostore.api.operations.tag.gettag.GetTagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tags")
@RequiredArgsConstructor
public class TagController {
private final CreateTagOperation createTag;
private final EditTagNameOperation editTagName;
private final GetAllITagsOperation getAllITags;
private final GetTagOperation getTag;

@PostMapping(path="/tag")
    public ResponseEntity<CreateTagResponse> createTag(@RequestBody CreateTagRequest request){
    return ResponseEntity.ok(this.createTag.process(request));
}

@PatchMapping("/tag")
    public ResponseEntity<EditTagResponse> editTagName(@RequestBody EditTagRequest request){
    return ResponseEntity.ok(this.editTagName.process(request));
}

@GetMapping("/tags")
    public ResponseEntity<GetAllTagsResponse> getAllTags(){
    return ResponseEntity.ok(this.getAllITags.process(new GetAllTagRequest()));
}

@GetMapping(path="/tag/{id}")
    public ResponseEntity<GetTagResponse> getTag(@PathVariable String id){
    return ResponseEntity.ok(this.getTag.process(GetTagRequest.builder().tagId(id).build()));
}
}
