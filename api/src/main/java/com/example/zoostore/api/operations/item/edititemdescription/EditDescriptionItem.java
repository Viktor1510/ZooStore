package com.example.zoostore.api.operations.item.edititemdescription;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditDescriptionItem implements OperationRequest {
    private String id;
    @NotEmpty
    private String description;

}
