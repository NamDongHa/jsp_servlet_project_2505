package com.ndh1614.jsp_servlet_project_2505.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeePolicyDTO {
    private int no;           // 요금제 개수
    private String carType;
    private String timeType; // "주간" 또는 "야간"
    private int baseTime;        // 기본 시간 (분 단위)
    private int baseFee;         // 기본 요금
    private int unitTime;        // 추가 시간 단위
    private int unitFee;         // 추가 요금
    private int dailyMaxFee;     // 일일 최대 요금

    private int discount;  // 할인율 (예: 50)

}
