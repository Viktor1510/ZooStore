package com.example.zoostore.api.operations.multimedia.getmultimedia;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMultimediaRequest implements OperationRequest {
    private UUID multimediaId;
}
