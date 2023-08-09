package com.example.zoostore.controllers;

import com.example.zoostore.api.operations.item.createItem.CreateItemOperation;
import com.example.zoostore.api.operations.item.createItem.CreateItemRequest;
import com.example.zoostore.api.operations.item.createItem.CreateItemResponse;
import com.example.zoostore.api.operations.item.edititem.EditItemOperation;
import com.example.zoostore.api.operations.item.edititem.EditItemRequest;
import com.example.zoostore.api.operations.item.edititem.EditItemResponse;
import com.example.zoostore.api.operations.item.edititemdescription.EditDescriptionItem;
import com.example.zoostore.api.operations.item.edititemdescription.EditItemDescriptionOperation;
import com.example.zoostore.api.operations.item.edititemdescription.EditItemDescriptionResponse;
import com.example.zoostore.api.operations.item.edititemmultimedia.EditItemMultimedia;
import com.example.zoostore.api.operations.item.edititemmultimedia.EditItemMultimediaOperation;
import com.example.zoostore.api.operations.item.edititemmultimedia.EditItemMultimediaResponse;
import com.example.zoostore.api.operations.item.edititemtags.EditItemTags;
import com.example.zoostore.api.operations.item.edititemtags.EditItemTagsOperation;
import com.example.zoostore.api.operations.item.edititemtags.EditItemTagsResponse;
import com.example.zoostore.api.operations.item.edititemtitle.EditItemTitle;
import com.example.zoostore.api.operations.item.edititemtitle.EditItemTitleOperation;
import com.example.zoostore.api.operations.item.edititemtitle.EditItemTitleResponse;
import com.example.zoostore.api.operations.item.edititemvendor.EditItemVendorOperation;
import com.example.zoostore.api.operations.item.edititemvendor.EditItemVendorRequest;
import com.example.zoostore.api.operations.item.edititemvendor.EditItemVendorResponse;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemResponse;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemsOperation;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemsRequest;
import com.example.zoostore.api.operations.item.getitem.GetItemOperation;
import com.example.zoostore.api.operations.item.getitem.GetItemRequest;
import com.example.zoostore.api.operations.item.getitem.GetItemResponse;
import com.example.zoostore.api.operations.item.getitembyid.GetItemByIdOperation;
import com.example.zoostore.api.operations.item.getitembyid.GetItemByIdRequest;
import com.example.zoostore.api.operations.item.getitembyid.GetItemByIdResponse;
import com.example.zoostore.api.operations.item.getitemsbytag.GetItemsByTagOperation;
import com.example.zoostore.api.operations.item.getitemsbytag.GetItemsByTagRequest;
import com.example.zoostore.api.operations.item.updatearchivestatus.UpdateArchiveStatusOperation;
import com.example.zoostore.api.operations.item.updatearchivestatus.UpdateArchiveStatusRequest;
import com.example.zoostore.api.operations.item.updatearchivestatus.UpdateArchiveStatusResponse;
import jakarta.validation.GroupSequence;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/items")
public class ItemController {
    private final CreateItemOperation createItemOperation;
    private final GetAllItemsOperation getAllItem;
    private final GetItemOperation getItem;

    private final EditItemOperation editItem;


    private final GetItemByIdOperation getItemByIdOperation;

    private final GetItemsByTagOperation getItemsByTag;

    @PostMapping(path="/item")
    public ResponseEntity<CreateItemResponse> createItem(@RequestBody CreateItemRequest request) {
        return new ResponseEntity<>(this.createItemOperation.process(request), HttpStatus.CREATED);
    }
    @GetMapping(path="/items")
    public ResponseEntity<GetAllItemResponse> getAllItems(){
        return ResponseEntity.ok(this.getAllItem.process(new GetAllItemsRequest()));
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<GetItemResponse> getItem(@PathVariable String id){
        return ResponseEntity.ok(this.getItem.process(GetItemRequest.builder().id(UUID.fromString(id)).build()));
    }
    @GetMapping(path="/item/{id}")
    public ResponseEntity<GetItemByIdResponse> getItemById(@PathVariable String id){
        return ResponseEntity.ok(this.getItemByIdOperation.process(GetItemByIdRequest.builder().id(UUID.fromString(id)).build()));
    }
    @PutMapping(path="/item")
    public ResponseEntity<EditItemResponse> editItem(@RequestBody EditItemRequest request){
        return ResponseEntity.ok(this.editItem.process(request));
    }

    @GetMapping(path = "/tag")
    public ResponseEntity<GetAllItemResponse> getAllItemsByTag(@RequestParam Boolean isArchived,
                                                               @RequestParam UUID id,
                                                               @RequestParam Integer pageNumber,
                                                               @RequestParam Integer page ){
        return ResponseEntity.ok(this.getItemsByTag.process(GetItemsByTagRequest.builder()
                .tagId(id).isArchived(isArchived)
                .pageNumber(pageNumber)
                .NumberOfItemsPerPage(page)
                .build()));
    }


}


