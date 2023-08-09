package com.example.zoostore.api.operations.item.getitem;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetItemRequest implements OperationRequest {
    private UUID id;

}
