package com.example.zoostore.models;

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
    private UUID vendorId;
}
