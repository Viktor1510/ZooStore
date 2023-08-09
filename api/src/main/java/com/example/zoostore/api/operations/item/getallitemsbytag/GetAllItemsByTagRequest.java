package com.example.zoostore.api.operations.item.getallitemsbytag;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllItemsByTagRequest {
    private String tagId;
}
