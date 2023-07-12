package com.example.zoostore.services;

import com.example.zoostore.interfaces.ItemService;
import com.example.zoostore.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

/*
    @Override
    public Item createItem(Item item) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item editItemTitle(String oldTitle, String newTitle) {
        return null;
    }

    @Override
    public Vendor getVendor(Vendor vendor) {
        return null;
    }

    @Override
    public Item editItemDescription(String description) {
        return null;
    }

    @Override
    public Vendor changeVendor() {
        return null;
    }*/
}
