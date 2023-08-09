package com.example.zoostore.api.operations.item.edititem;

import com.example.zoostore.api.base.OperationResult;
import jakarta.annotation.Nullable;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditItemResponse implements OperationResult {
    private UUID id;
    @Nullable
    private String description;
    @Nullable
    private String title;
    @Nullable
    private String vendorId;
    @Nullable
    private String[] multimediaIds;
    @Nullable
    private String[] tagIds;
    @Nullable
    private boolean isArchived;
}
