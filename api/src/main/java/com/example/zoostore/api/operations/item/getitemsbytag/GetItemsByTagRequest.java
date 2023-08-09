package com.example.zoostore.api.operations.item.getitemsbytag;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;
import org.hibernate.sql.ast.tree.predicate.BooleanExpressionPredicate;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetItemsByTagRequest implements OperationRequest {
    private Boolean isArchived;
    private UUID tagId;
    private Integer pageNumber;
    private Integer NumberOfItemsPerPage;
}
