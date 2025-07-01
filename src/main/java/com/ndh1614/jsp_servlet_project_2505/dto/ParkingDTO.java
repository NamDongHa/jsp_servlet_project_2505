package com.ndh1614.jsp_servlet_project_2505.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ParkingDTO {
    private String carId; //차량번호
    private LocalDateTime carInTime; //입차시간
    private LocalDateTime carOutTime; //출차시간
    private int parkingFee; // 요금
}
