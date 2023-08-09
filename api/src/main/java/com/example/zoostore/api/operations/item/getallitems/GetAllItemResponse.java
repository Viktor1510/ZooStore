package com.example.zoostore.api.operations.item.getallitems;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllItemResponse  implements OperationResult {
    private List<GetAllItemSingle> responses;
}
