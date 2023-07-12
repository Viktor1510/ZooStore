package com.example.zoostore.Data.response.multimedia;

import com.example.zoostore.models.GetAllMultimediaSingleItem;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllMultimediaResponse {
    private List<GetAllMultimediaSingleItem> multimediaResponses;
}
