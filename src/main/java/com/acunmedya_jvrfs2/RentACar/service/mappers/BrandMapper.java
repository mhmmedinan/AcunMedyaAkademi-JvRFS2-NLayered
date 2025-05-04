package com.acunmedya_jvrfs2.RentACar.service.mappers;

import com.acunmedya_jvrfs2.RentACar.entity.Brand;
import com.acunmedya_jvrfs2.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.DeletedBrandResponse;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.GetListBrandResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);


    Brand brandFromCreateBrandRequest(CreateBrandRequest createBrandRequest);
    CreatedBrandResponse createdBrandResponseFromBrand(Brand brand);
    GetListBrandResponse getListBrandResponseFromBrand(Brand brand);
    DeletedBrandResponse deletedBrandResponseFromBrand(Brand brand);
}
