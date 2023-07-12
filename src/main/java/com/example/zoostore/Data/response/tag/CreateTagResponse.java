package com.example.zoostore.Data.response.tag;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTagResponse {
    private String  tagId;
    private String name;
    private String itemId;
}
