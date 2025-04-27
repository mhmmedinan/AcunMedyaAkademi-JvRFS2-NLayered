package com.acunmedya_jvrfs2.RentACar.service.abstracts;

import com.acunmedya_jvrfs2.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.model.GetListModelResponse;

import java.util.List;

public interface ModelService {

    CreatedModelResponse add(CreateModelRequest request);
    List<GetListModelResponse> getList();
    List<GetListModelResponse> getByBrandName(String brandName);
}
