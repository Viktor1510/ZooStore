package com.example.zoostore.Data.request.vendor;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateVendorRequest {
    @NotEmpty
    private String name;

}
