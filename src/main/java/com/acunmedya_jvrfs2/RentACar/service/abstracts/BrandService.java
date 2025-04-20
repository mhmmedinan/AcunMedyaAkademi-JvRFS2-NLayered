package com.acunmedya_jvrfs2.RentACar.service.abstracts;

import com.acunmedya_jvrfs2.RentACar.entity.Brand;

import java.util.List;

public interface BrandService {

    void add(Brand brand);
    List<Brand> getAll();
}
