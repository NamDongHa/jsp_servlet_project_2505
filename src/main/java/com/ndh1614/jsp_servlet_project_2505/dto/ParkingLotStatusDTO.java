package com.ndh1614.jsp_servlet_project_2505.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ParkingLotStatusDTO {
    private int totalSpots;     // 전체 자리 (예: 10)
    private int usedSpots;      // 현재 주차된 차량 수
    private int availableSpots; // 남은 자리 수 = total - used
}
