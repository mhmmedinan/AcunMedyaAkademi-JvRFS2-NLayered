package com.acunmedya_jvrfs2.RentACar.repository;

import com.acunmedya_jvrfs2.RentACar.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
    List<Model> findByBrandName(String brandName);
}
