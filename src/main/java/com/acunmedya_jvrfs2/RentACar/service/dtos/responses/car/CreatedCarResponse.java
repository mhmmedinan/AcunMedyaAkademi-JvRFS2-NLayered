package com.acunmedya_jvrfs2.RentACar.service.dtos.responses.car;

public record CreatedCarResponse(int id,int modelId,int modelYear,String plate, double dailyPrice,int kilometer) {
}
