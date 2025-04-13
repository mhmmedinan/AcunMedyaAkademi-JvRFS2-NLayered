package com.acunmedya_jvrfs2.RentACar.controller;

import com.acunmedya_jvrfs2.RentACar.entity.Brand;
import com.acunmedya_jvrfs2.RentACar.repository.BrandRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController  //api sınıfı olması için işaretliyoruz
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    //GET
    @GetMapping
    public List<Brand> getBrands(){
        return brandRepository.findAll();
    }

    //GET => id'ye göre getir
    @GetMapping("/{id}")  //POST => Create,PUT => Update,DELETE => Delete
    public ResponseEntity<Brand> getById(@PathVariable int id){
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
