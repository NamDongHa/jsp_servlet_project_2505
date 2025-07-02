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
    private int parkingMinute; // 입차 이후 경과 시간 (단위: 분)
    private String carInTime; //입차시간
}
