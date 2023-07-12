package com.example.zoostore.Data.request.vendor;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditVendorRequest {
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
}
