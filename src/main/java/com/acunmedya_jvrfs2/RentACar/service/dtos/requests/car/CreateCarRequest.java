package com.acunmedya_jvrfs2.RentACar.service.dtos.requests.car;

public record CreateCarRequest(int modelId,int modelYear,String plate, double dailyPrice,int kilometer) {
}
