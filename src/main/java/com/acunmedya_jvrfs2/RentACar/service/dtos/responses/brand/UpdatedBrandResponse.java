package com.acunmedya_jvrfs2.RentACar.service.dtos.responses.brand;

public class UpdatedBrandResponse {

    private int id;
    private String name;

    public UpdatedBrandResponse(){

    }

    public UpdatedBrandResponse(int id, String name) {
        this.id=id;
        this.name = name;
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
}
