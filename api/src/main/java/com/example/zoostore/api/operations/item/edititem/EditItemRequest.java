package com.example.zoostore.api.operations.item.edititem;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditItemRequest implements OperationRequest {
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
