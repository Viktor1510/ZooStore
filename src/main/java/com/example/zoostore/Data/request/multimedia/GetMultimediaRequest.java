package com.example.zoostore.Data.request.multimedia;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMultimediaRequest {
    private UUID multimediaId;
}
