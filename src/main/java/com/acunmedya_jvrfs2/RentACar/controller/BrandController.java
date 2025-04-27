package com.acunmedya_jvrfs2.RentACar.controller;

import com.acunmedya_jvrfs2.RentACar.service.abstracts.BrandService;
import com.acunmedya_jvrfs2.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya_jvrfs2.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.GetBrandResponse;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.GetListBrandResponse;
import com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand.UpdatedBrandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //api sınıfı olması için işaretliyoruz
@RequestMapping("/api/brands")
public class BrandController {

   /* private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }*/

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    //GET
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListBrandResponse> getBrands(){
        return brandService.getAll();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponse getByName(@PathVariable String name){
        return brandService.getByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreatedBrandResponse add(@RequestBody CreateBrandRequest request){
        return brandService.add(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBrandResponse update(@RequestBody UpdateBrandRequest request){
        return brandService.update(request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable int id){
        brandService.delete(id);
    }

   /* //GET => id'ye göre getir
    @GetMapping("/{id}")  //POST => Create,PUT => Update,DELETE => Delete
    public ResponseEntity<Brand> getById(@PathVariable int id){
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }*/
}
