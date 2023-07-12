package com.example.zoostore.services;

import com.example.zoostore.Data.request.tag.CreateTagRequest;
import com.example.zoostore.Data.request.tag.EditTagRequest;
import com.example.zoostore.Data.request.tag.GetTagRequest;
import com.example.zoostore.Data.response.tag.CreateTagResponse;
import com.example.zoostore.Data.response.tag.EditTagResponse;
import com.example.zoostore.Data.response.tag.GetAllTagsResponse;
import com.example.zoostore.Data.response.tag.GetTagResponse;
import com.example.zoostore.interfaces.TagService;
import org.springframework.stereotype.Service;

@Service

public class TagServiceImpl implements TagService {


    @Override
    public CreateTagResponse createTag(CreateTagRequest request) {

        return null;
    }

    @Override
    public EditTagResponse editTagName(EditTagRequest request) {
        return null;
    }

    @Override
    public GetAllTagsResponse getAllTags() {
        return null;
    }

    @Override
    public GetTagResponse getTag(GetTagRequest request) {
        return null;
    }
}
