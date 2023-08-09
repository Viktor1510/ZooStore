package com.example.zoostore.api.operations.tag.gettag;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTagRequest implements OperationRequest {
    @NotEmpty
    private String tagId;
}
