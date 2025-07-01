package com.ndh1614.jsp_servlet_project_2505.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SubscriptionDTO {
    private int id;
    private int memberId;
    private String type;       // 월정액 or 연정액
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;     // active, expired
    private int fee;
}
