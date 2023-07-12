package com.example.zoostore.Data.response.vendor;

import com.example.zoostore.models.GetAllVendorsSingleItem;
import lombok.*;

import java.util.List;
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllVendorsResponse {
   private List<GetAllVendorsSingleItem> vendorResponses;

}
