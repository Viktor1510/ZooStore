package com.example.zoostore.api.operations.item.createItem;
import com.example.zoostore.api.base.OperationRequest;
import jakarta.annotation.Nullable;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateItemRequest implements OperationRequest {

    private String description;
    private String title;
    private String vendorId;
    private String[] multimediaIds;
    private String[] tagIds;
    private boolean isArchived;
}
