package com.example.zoostore.controllers;

import com.example.zoostore.interfaces.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

  /* @PostMapping
    public ResponseEntity<CreateItemResponse> createItem(@RequestBody @Valid CreateItemRequest request, BindingResult result){

        if(result.hasErrors())
     {
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
     return  new ResponseEntity<>(itemService.addItem(request),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {

    }

    @GetMapping(path = "/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable String itemId) {

    }

    @PatchMapping("/{itemId}")
    public ResponseEntity<Item> editItemByAllParams(@PathVariable String itemId, @RequestBody Item item){

    }

    @PatchMapping("/{itemId}/edit-vendor")
    public ResponseEntity<Item> editItemByVendor(@PathVariable String itemId, @RequestBody Item item)
    {

    }
    @DeleteMapping("/{itemId}/tags")
    public ResponseEntity<Item> deleteItemTags(@PathVariable String itemId, @RequestBody EditTags editTagsDTO){

    }*/

}


