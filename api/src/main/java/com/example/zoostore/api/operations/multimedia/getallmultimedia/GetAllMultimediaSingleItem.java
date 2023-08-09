package com.example.zoostore.api.operations.multimedia.getallmultimedia;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllMultimediaSingleItem {
    private String multimediaId;
    private String url;
    private String itemId;
}
