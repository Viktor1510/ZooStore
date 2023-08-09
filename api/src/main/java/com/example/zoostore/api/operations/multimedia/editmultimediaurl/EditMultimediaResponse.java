package com.example.zoostore.api.operations.multimedia.editmultimediaurl;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditMultimediaResponse implements OperationResult {
    private UUID multimediaId;
    private String url;
    private UUID itemId;
}
