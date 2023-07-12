package com.example.zoostore.Data.request.tag;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllTagRequest {
    List<GetTagRequest> tagRequests;
}
