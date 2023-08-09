package com.example.zoostore.api.operations.vendor.getvendor;


import com.example.zoostore.api.base.OperationRequest;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetVendorRequest implements OperationRequest {
    private String id;
}
