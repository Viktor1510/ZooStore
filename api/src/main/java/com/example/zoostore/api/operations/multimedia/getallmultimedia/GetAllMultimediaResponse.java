package com.example.zoostore.api.operations.multimedia.getallmultimedia;

import com.example.zoostore.api.base.OperationResult;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaSingleItem;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllMultimediaResponse implements OperationResult {
    private List<GetAllMultimediaSingleItem> multimediaResponses;
}
