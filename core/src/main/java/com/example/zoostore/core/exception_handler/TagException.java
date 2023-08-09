package com.example.zoostore.core.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Tag not found")
public class TagException extends  RuntimeException{
}
