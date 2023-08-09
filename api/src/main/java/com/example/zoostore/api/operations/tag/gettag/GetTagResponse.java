package com.example.zoostore.api.operations.tag.gettag;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTagResponse implements OperationResult {
    private String tagId;
    private String name;
    private String itemId;
}
