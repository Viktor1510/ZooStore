package com.example.zoostore.api.operations.multimedia.createMultimedia;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMultimediaRequest implements OperationRequest {
    @NotEmpty
    private String url;

}
