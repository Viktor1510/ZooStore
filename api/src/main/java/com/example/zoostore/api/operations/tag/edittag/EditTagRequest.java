package com.example.zoostore.api.operations.tag.edittag;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditTagRequest implements OperationRequest {
    @NotEmpty
    private String id;
    private String name;
}
