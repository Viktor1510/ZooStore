package com.example.zoostore.api.operations.tag.getalltags;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllTagSingleItem {
    private String tagId;
    private String name;
}
