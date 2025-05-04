package com.acunmedya_jvrfs2.RentACar.repository;

import com.acunmedya_jvrfs2.RentACar.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
    /*List<Model> findByBrandName(String brandName);*/

    @Query("Select m From Model m Where m.brand.name = :brandName")  //JPQL (Entity) bazlı Query
    List<Model> findByBrandName(@Param("brandName") String brandName);

    @Query(value = "Select * from models where brand_id=:brandId",nativeQuery = true) //Native query
    List<Model> findByBrandIdNative(@Param("brandId") int brandId);
}
