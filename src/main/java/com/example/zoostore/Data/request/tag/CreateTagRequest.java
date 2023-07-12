package com.example.zoostore.Data.request.tag;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTagRequest {
    @NotEmpty
    private String name;
    private String itemId;

}
