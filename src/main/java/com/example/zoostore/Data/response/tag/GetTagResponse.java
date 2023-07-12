package com.example.zoostore.Data.response.tag;

import lombok.*;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTagResponse {
    private String tagId;
    private String name;
    private String itemId;
}
