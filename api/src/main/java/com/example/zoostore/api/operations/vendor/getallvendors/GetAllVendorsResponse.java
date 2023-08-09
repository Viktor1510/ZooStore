package com.example.zoostore.api.operations.vendor.getallvendors;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsSingleItem;
import lombok.*;

import java.util.List;
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllVendorsResponse implements OperationResult {
   private List<GetAllVendorsSingleItem> vendorResponses;

}
