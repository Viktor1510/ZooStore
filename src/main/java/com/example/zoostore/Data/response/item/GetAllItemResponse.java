package com.example.zoostore.Data.response.item;

import com.example.zoostore.models.GetAllItemSingle;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllItemResponse {
    private List<GetAllItemSingle> responses;
}
