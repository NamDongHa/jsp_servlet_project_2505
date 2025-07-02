package com.ndh1614.jsp_servlet_project_2505.domain;


import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeePolicyVO {
    private int no;           // 차량 아이디
    private String carType;
    private String timeType; // "주간" 또는 "야간"
    private int baseTime;        // 기본 시간 (분 단위)
    private int baseFee;         // 기본 요금
    private int unitTime;        // 추가 시간 단위
    private int unitFee;         // 추가 요금
    private int dailyMaxFee;     // 일일 최대 요금

    private double discountDisabled;  // 장애인 할인율 (예: 50)
    private double discountCompact;   // 경차 할인율 (예: 30)
}
