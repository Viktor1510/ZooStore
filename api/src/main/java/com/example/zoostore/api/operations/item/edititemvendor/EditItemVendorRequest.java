package com.example.zoostore.api.operations.item.edititemvendor;

import com.example.zoostore.api.base.OperationRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditItemVendorRequest implements OperationRequest {
    private String id;
    private String vendorId;

}
