package com.example.zoostore.Data.request.item;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetItemRequest {
    @NotEmpty(message = "Description cannot stay empty!") @Length(min=20, max=70)
    private String description;
    @NotEmpty(message = "Title cannot stay empty!") @Length(min=5, max=30)
    private String title;
    @NotEmpty
    private UUID vendorId;
    private String[] multimediaIds;
    private String[] tagIds;
}
