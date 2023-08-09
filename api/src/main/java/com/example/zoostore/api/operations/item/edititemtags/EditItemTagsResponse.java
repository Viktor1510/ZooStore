package com.example.zoostore.api.operations.item.edititemtags;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditItemTagsResponse implements OperationResult {
    private UUID id;
    private String description;
    private String title;
    private String vendorId;
    private String[] multimediaIds;
    private String[] tagIds;
}
