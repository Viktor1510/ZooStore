package com.example.zoostore.core.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Vendor not found")
public class VendorException extends RuntimeException{
}
