package com.ndh1614.jsp_servlet_project_2505.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingVO {
    private String carId; //차량번호
    private LocalDate carInTime; //입차시간
    private LocalDate carOutTime; //출차시간
    private int parkingFee; // 요금
}
