package com.example.zoostore.api.operations.vendor.editvendor;

import com.example.zoostore.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditVendorRequest implements OperationRequest {
    @NotEmpty
    private String id;
    private String name;

}
