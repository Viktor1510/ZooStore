package com.example.zoostore.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such multimedia")
public class MultiMediaException extends RuntimeException{
}
