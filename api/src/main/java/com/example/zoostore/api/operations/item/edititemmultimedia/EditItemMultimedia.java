package com.example.zoostore.api.operations.item.edititemmultimedia;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditItemMultimedia implements OperationRequest {
    private String id;
    private String[] multimedia;
}
