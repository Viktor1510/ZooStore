package com.example.zoostore.Data.request.multimedia;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMultimediaRequest {
    private UUID multimediaId;
    @NotEmpty
    private String url;
    private String itemId;
}
