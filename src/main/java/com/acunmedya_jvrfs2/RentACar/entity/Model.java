package com.acunmedya_jvrfs2.RentACar.entity;

import com.acunmedya_jvrfs2.RentACar.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "models")
@SQLRestriction(value = "deleted_at IS NULL")
public class Model extends BaseEntity {

    @Id //primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Otomatik artan ID
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="brandId")
    private Brand brand; //ManyToOne

    @OneToMany(mappedBy = "model")
    private List<Car> cars;



    public Model(){

    }

    public Model(int id, String name, Brand brand,List<Car> cars) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cars = cars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
