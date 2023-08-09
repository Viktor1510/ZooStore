package com.example.zoostore.api.base;


public interface Processor<Response extends OperationResult, Request extends OperationRequest> {
    Response process(Request request);
}
