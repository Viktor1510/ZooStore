package com.example.zoostore.Data.response.item;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetItemResponse {
    private UUID id;
}
