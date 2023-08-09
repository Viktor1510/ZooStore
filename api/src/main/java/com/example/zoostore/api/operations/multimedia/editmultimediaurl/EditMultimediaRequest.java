package com.example.zoostore.api.operations.multimedia.editmultimediaurl;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditMultimediaRequest  implements OperationRequest {
    private UUID multimediaId;
    private String url;
}
