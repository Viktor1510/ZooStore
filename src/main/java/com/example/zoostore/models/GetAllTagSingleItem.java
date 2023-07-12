package com.example.zoostore.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllTagSingleItem {
    private String tagId;
    private String itemId;
    private String name;
}
