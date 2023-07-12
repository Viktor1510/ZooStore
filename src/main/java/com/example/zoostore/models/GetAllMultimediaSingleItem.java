package com.example.zoostore.models;

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
