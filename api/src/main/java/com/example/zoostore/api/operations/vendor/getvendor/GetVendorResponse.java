package com.example.zoostore.api.operations.vendor.getvendor;

import com.example.zoostore.api.base.OperationResult;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetVendorResponse implements OperationResult {
    private UUID id;
    private String name;
}
