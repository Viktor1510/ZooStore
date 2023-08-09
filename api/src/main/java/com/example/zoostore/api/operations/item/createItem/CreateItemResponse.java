package com.example.zoostore.api.operations.item.createItem;
import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateItemResponse implements OperationResult {
    private String id;
    private String description;
    private String title;
    private String vendorId;
    private String[] multimediaIds;
    private String[] tagIds;



}
