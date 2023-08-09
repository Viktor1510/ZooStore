package com.example.zoostore.api.operations.multimedia.createMultimedia;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMultimediaResponse implements OperationResult
{
    private UUID multimediaId;
    private String url;
    private String itemId;
}
