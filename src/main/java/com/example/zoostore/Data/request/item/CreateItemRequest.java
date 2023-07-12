package com.example.zoostore.Data.request.item;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateItemRequest {
   @NotEmpty
    private String description;
   @NotEmpty
    private String title;
   @NotEmpty
    private String vendorId;
    private String[] multimediaIds;
    private String[] tagIds;
}
