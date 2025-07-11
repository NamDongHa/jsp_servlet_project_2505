package com.ndh1614.jsp_servlet_project_2505.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CheckOutDTO {
    private String carId; // 차량 번호
    private LocalDateTime carOutTime; // 출차 시간
    private int parkingFee; // 요금
}
