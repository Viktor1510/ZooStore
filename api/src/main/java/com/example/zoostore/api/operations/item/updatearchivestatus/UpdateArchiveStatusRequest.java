package com.example.zoostore.api.operations.item.updatearchivestatus;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateArchiveStatusRequest implements OperationRequest {
    private String id;
    private Boolean update;
}
