package com.ndh1614.jsp_servlet_project_2505.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckOutVO {
    private String carId; // 차량 번호
    private LocalDateTime carOutTime; // 출차 시간
    private int parkingFee; // 요금
}
