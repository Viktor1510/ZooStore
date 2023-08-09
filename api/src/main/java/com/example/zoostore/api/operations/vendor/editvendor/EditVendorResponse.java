package com.example.zoostore.api.operations.vendor.editvendor;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditVendorResponse implements OperationResult {
    private UUID id;
    private String name;
}
