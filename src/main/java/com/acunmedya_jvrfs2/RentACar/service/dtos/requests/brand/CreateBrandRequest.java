package com.acunmedya_jvrfs2.RentACar.service.dtos.requests.brand;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateBrandRequest {

    @NotEmpty(message = "Brand name cannot be empty")
    @Size(min = 2,max = 30)
    private String name;

    public CreateBrandRequest(){

    }

    public CreateBrandRequest(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
