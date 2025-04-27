package com.acunmedya_jvrfs2.RentACar.service.dtos.responses.car;

public record GetListCarResponse(int id,int modelId,String modelName,int modelYear,String plate, double dailyPrice,int kilometer) {
}
