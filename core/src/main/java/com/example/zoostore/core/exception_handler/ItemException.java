package com.example.zoostore.core.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;


@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Vendor not found")
public class ItemException extends RuntimeException{
    public ItemException(UUID id) {
        super(String.format("Item with id "+id+" not found!"));
    }
}
