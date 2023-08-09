package com.example.zoostore.api.operations.vendor.createvendor;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateVendorRequest implements OperationRequest {
    @NotEmpty
    private String name;

}
