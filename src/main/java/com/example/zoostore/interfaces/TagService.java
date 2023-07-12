package com.example.zoostore.interfaces;

import com.example.zoostore.Data.request.tag.CreateTagRequest;
import com.example.zoostore.Data.request.tag.EditTagRequest;
import com.example.zoostore.Data.request.tag.GetTagRequest;
import com.example.zoostore.Data.response.tag.CreateTagResponse;
import com.example.zoostore.Data.response.tag.EditTagResponse;
import com.example.zoostore.Data.response.tag.GetAllTagsResponse;
import com.example.zoostore.Data.response.tag.GetTagResponse;

public interface TagService {
    CreateTagResponse createTag(CreateTagRequest request);

    EditTagResponse editTagName(EditTagRequest request);

    GetAllTagsResponse getAllTags();

    GetTagResponse getTag(GetTagRequest request);
}
