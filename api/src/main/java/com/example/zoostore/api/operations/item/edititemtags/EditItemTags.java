package com.example.zoostore.api.operations.item.edititemtags;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditItemTags implements OperationRequest {
    private String id;
    private String[] tagIds;
}
