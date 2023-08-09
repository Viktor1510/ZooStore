package com.example.zoostore.api.operations.tag.getalltags;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.tag.getalltags.GetAllTagSingleItem;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllTagsResponse implements OperationResult {
    private List<GetAllTagSingleItem> tagResponses;
}
