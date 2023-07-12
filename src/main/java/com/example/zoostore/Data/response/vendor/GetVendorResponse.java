package com.example.zoostore.Data.response.vendor;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetVendorResponse {
    private UUID id;
    private String name;
}
