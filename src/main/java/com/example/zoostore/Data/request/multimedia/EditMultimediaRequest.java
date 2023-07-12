package com.example.zoostore.Data.request.multimedia;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditMultimediaRequest {
    private UUID multimediaId;
    private String itemId;
    private String url;
}
