package com.example.zoostore.api.operations.tag.edittag;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EditTagResponse implements OperationResult {
    private String tagId;
    private String name;
}
