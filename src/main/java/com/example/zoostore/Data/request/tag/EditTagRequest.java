package com.example.zoostore.Data.request.tag;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditTagRequest {
    @NotEmpty
    private String tagId;
    @NotEmpty
    private String name;
    private String itemId;
}
