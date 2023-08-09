package com.example.zoostore.api.operations.item.getallitems;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllItemSingle {
    private UUID itemId;
    private String title;
    private String description;
    private String vendorId;
    private String[] tagIds;
    private String[] multimediaIds;
}
