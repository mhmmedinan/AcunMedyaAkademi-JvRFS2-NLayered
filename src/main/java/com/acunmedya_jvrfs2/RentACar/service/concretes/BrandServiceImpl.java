package com.acunmedya_jvrfs2.RentACar.service.concretes;

import com.acunmedya_jvrfs2.RentACar.entity.Brand;
import com.acunmedya_jvrfs2.RentACar.repository.BrandRepository;
import com.acunmedya_jvrfs2.RentACar.service.abstracts.BrandService;
import com.acunmedya_jvrfs2.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya_jvrfs2.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.*;
import com.acunmedya_jvrfs2.RentACar.service.mappers.BrandMapper;
import com.acunmedya_jvrfs2.RentACar.service.rules.BrandBusinessRules;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandBusinessRules rules;

    public BrandServiceImpl(BrandRepository brandRepository, BrandBusinessRules rules) {
        this.brandRepository = brandRepository;
        this.rules = rules;
    }

    @Override
    public CreatedBrandResponse add(CreateBrandRequest request) {
      /* Brand brand = new Brand();
       brand.setName(request.getName());
       Brand createdBrand = brandRepository.save(brand);

       CreatedBrandResponse response = new CreatedBrandResponse();
       response.setId(createdBrand.getId());
       response.setName(createdBrand.getName());
       return response;*/

        rules.checkIfBrandNameExists(request.getName());

        Brand brand = BrandMapper.INSTANCE.brandFromCreateBrandRequest(request);
        Brand createdBrand = brandRepository.save(brand);
        CreatedBrandResponse response= BrandMapper.INSTANCE.createdBrandResponseFromBrand(createdBrand);
        return response;

    }

    @Override
    public List<GetListBrandResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetListBrandResponse> responses= brands.stream()
                .map(BrandMapper.INSTANCE::getListBrandResponseFromBrand).collect(Collectors.toList());
        return responses;
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = brandRepository.
                findById(updateBrandRequest.getId()).orElseThrow(()-> new RuntimeException("Brand not found"));
        brand.setName(updateBrandRequest.getName());
        Brand updatedBrand = brandRepository.save(brand);
        UpdatedBrandResponse response = new UpdatedBrandResponse();
        response.setId(updatedBrand.getId());
        response.setName(updatedBrand.getName());
        return response;
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public GetBrandResponse getByName(String name) {
       Brand brand = brandRepository.getByNameIgnoreCase(name).orElseThrow(() ->new RuntimeException("Brand not found"));
       return mapToBrandResponse(brand);
    }

    @Override
    public DeletedBrandResponse softDelete(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() ->new RuntimeException("Brand not found"));
        brand.setDeletedAt(LocalDateTime.now());
        Brand deletedBrand = brandRepository.save(brand);
        DeletedBrandResponse response = BrandMapper.INSTANCE.deletedBrandResponseFromBrand(deletedBrand);
        return response;
    }


   /* private GetListBrandResponse mapToResponse(Brand brand){
        GetListBrandResponse response = new GetListBrandResponse();
        response.setId(brand.getId());
        response.setName(brand.getName());
        return response;
    }*/

    private GetBrandResponse mapToBrandResponse(Brand brand){
        GetBrandResponse response = new GetBrandResponse();
        response.setId(brand.getId());
        response.setName(brand.getName());
        return response;
    }
}
