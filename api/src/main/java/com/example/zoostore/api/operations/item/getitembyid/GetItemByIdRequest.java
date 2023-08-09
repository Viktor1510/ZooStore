package com.example.zoostore.api.operations.item.getitembyid;

import com.example.zoostore.api.base.OperationRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class GetItemByIdRequest implements OperationRequest {
    private UUID id;
}
