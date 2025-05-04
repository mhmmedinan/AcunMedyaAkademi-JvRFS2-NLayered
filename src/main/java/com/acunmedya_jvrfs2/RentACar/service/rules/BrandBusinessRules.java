package com.acunmedya_jvrfs2.RentACar.service.rules;

import com.acunmedya_jvrfs2.RentACar.common.exceptions.types.BusinessException;
import com.acunmedya_jvrfs2.RentACar.entity.Brand;
import com.acunmedya_jvrfs2.RentACar.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void checkIfBrandNameExists(String name){
        Brand brand = brandRepository.getByNameIgnoreCase(name).get();
        if(brand!=null)
            throw new BusinessException("Brand name already exists");
    }
}
