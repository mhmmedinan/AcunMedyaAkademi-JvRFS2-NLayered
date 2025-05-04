package com.acunmedya_jvrfs2.RentACar.repository;

import com.acunmedya_jvrfs2.RentACar.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    Optional<Brand> getByNameIgnoreCase(String name);
}
