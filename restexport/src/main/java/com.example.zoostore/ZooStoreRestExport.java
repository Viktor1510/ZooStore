package com.example.zoostore;
import com.example.zoostore.api.operations.item.createItem.CreateItemRequest;
import com.example.zoostore.api.operations.item.createItem.CreateItemResponse;
import com.example.zoostore.api.operations.item.edititem.EditItemRequest;
import com.example.zoostore.api.operations.item.edititem.EditItemResponse;
import com.example.zoostore.api.operations.item.getallitems.GetAllItemResponse;
import com.example.zoostore.api.operations.item.getitem.GetItemResponse;
import com.example.zoostore.api.operations.item.getitembyid.GetItemByIdResponse;
import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.createMultimedia.CreateMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaRequest;
import com.example.zoostore.api.operations.multimedia.editmultimediaurl.EditMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.getallmultimedia.GetAllMultimediaResponse;
import com.example.zoostore.api.operations.multimedia.getmultimedia.GetMultimediaResponse;
import com.example.zoostore.api.operations.tag.createtag.CreateTagRequest;
import com.example.zoostore.api.operations.tag.createtag.CreateTagResponse;
import com.example.zoostore.api.operations.tag.edittag.EditTagRequest;
import com.example.zoostore.api.operations.tag.edittag.EditTagResponse;
import com.example.zoostore.api.operations.tag.getalltags.GetAllTagsResponse;
import com.example.zoostore.api.operations.tag.gettag.GetTagResponse;
import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorRequest;
import com.example.zoostore.api.operations.vendor.createvendor.CreateVendorResponse;
import com.example.zoostore.api.operations.vendor.editvendor.EditVendorRequest;
import com.example.zoostore.api.operations.vendor.editvendor.EditVendorResponse;
import com.example.zoostore.api.operations.vendor.getallvendors.GetAllVendorsResponse;
import com.example.zoostore.api.operations.vendor.getvendor.GetVendorResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


@Headers({"Content-Type: application/json"})
public interface ZooStoreRestExport {

    @RequestLine("GET /item/{id}")
    GetItemByIdResponse getItemById(@Param("id") String id);

    @RequestLine("POST/items/item")
    CreateItemResponse createItem(@Param CreateItemRequest request);

    @RequestLine("GET/items/items")
    GetAllItemResponse getAllItems();

    @RequestLine("PUT/items/item")
    EditItemResponse editItem(@Param EditItemRequest request);

    @RequestLine("GET/items/{id}")
    GetItemResponse getItem(@Param("id") String id);


    @RequestLine("GET/multimedia/moreMultimedia")
    GetAllMultimediaResponse getAllMultimedia();

    @RequestLine("POST/multimedia/multimedia")
    CreateMultimediaResponse createMultimedia(@Param CreateMultimediaRequest request);

    @RequestLine("PUT/multimedia/multimedia")
    EditMultimediaResponse editMultimediaUrl(@Param EditMultimediaRequest request);

    @RequestLine("GET/multimedia/multimedia?id={id}")
    GetMultimediaResponse getMultimedia(@Param("id") String id);

    @RequestLine("POST/tags/tag")
    CreateTagResponse createTag(@Param CreateTagRequest request);

    @RequestLine("PATCH/tags/tag")
    EditTagResponse editTagName(@Param EditTagRequest request);

    @RequestLine("GET/tags/tags")
    GetAllTagsResponse getAllTags();

    @RequestLine("GET/tags/tag?tagId={id}")
    GetTagResponse getTag(@Param("id") String id);

    @RequestLine("POST/vendors/vendor")
    CreateVendorResponse createVendor(@Param CreateVendorRequest request);

    @RequestLine("PUT/vendors/vendor")
    EditVendorResponse editVendor(@Param EditVendorRequest request);

    @RequestLine("GET/vendors/vendors")
    GetAllVendorsResponse getAllVendors();

    @RequestLine("GET/vendors/items/{id}")
    GetAllItemResponse getAllVendorItems(@Param("id") String id);

    @RequestLine("GET/vendors/vendor/{id}")
    GetVendorResponse getVendor(@Param("id") String id);

}
