package com.ndh1614.jsp_servlet_project_2505.domain;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingVO {
    private String carId; //차량번호
    private int parkingMinute; // 입차 이후 경과 시간 (단위: 분)
    private LocalDateTime carInTime; //입차시간
}
