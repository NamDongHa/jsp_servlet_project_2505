package com.ndh1614.jsp_servlet_project_2505.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionVO {
    private int id;
    private int memberId;
    private String type;       // 월정액 or 연정액
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;     // active, expired
    private int fee;
}
