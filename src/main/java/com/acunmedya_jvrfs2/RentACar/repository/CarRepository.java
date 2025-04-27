package com.acunmedya_jvrfs2.RentACar.repository;

import com.acunmedya_jvrfs2.RentACar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    //Model yılı belirli bir yıldan büyük veya eşit olan arabaları getir
    List<Car> findByModelYearGreaterThanEqual(int modelYear);

    //Plaka içinde geçen ifadeye göre araçları getir
    List<Car> findByPlateContainingIgnoreCase(String partialPlate);
}
