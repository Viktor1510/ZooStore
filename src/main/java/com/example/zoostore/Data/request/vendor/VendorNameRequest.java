package com.example.zoostore.Data.request.vendor;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class VendorNameRequest {
    @NotEmpty
    private String name;
}
