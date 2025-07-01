package com.ndh1614.jsp_servlet_project_2505.util;

import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingFeeCalculator {

    private final FeePolicyVO policy;

    public ParkingFeeCalculator(FeePolicyVO policy) {
        this.policy = policy;
    }

    public int calculateFee(LocalDateTime inTime, LocalDateTime outTime, String carType, boolean isMonthly) {
        if (isMonthly) {
            return 0; // 월정액 회원은 무료
        }

        // 주차 시간(분 단위)
        long totalMinutes = Duration.between(inTime, outTime).toMinutes();

        // 기본 시간 이내면 기본 요금만
        int totalFee = policy.getBaseFee();

        if (totalMinutes > policy.getBaseTime()) {
            long extraMinutes = totalMinutes - policy.getBaseTime();
            long extraUnits = (long) Math.ceil((double) extraMinutes / policy.getUnitTime());
            totalFee += extraUnits * policy.getUnitFee();
        }

        // 일일 최대 요금 초과 시 제한
        totalFee = Math.min(totalFee, policy.getDailyMaxFee());

        // 할인 적용
        if ("장애인".equals(carType)) {
            totalFee = (int) (totalFee * (100 - policy.getDiscountDisabled()) / 100);
        } else if ("경차".equals(carType)) {
            totalFee = (int) (totalFee * (100 - policy.getDiscountCompact()) / 100);
        }

        return totalFee;
    }
}
