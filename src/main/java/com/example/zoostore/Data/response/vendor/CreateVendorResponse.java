package com.example.zoostore.Data.response.vendor;

import lombok.*;

import java.util.UUID;
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateVendorResponse {
    private UUID id;
    private String name;

}
