package com.example.zoostore.api.operations.tag.createtag;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTagRequest implements OperationRequest {
    @NotEmpty
    private String name;

}
