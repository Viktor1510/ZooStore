package com.example.zoostore.Data.response.multimedia;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetMultimediaResponse {
    private UUID multimediaId;
    private String url;
    private UUID itemId;
}
