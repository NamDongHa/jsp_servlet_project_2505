package com.ndh1614.jsp_servlet_project_2505.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor

public class MemberDTO {
    private String carId; //차량번호
    private String name; //소유주
    private String password; //비밀번호
    private String phone; //휴대폰번호
    private String type; // 일반/경차/장애인
    private boolean monthPay; //월정액
}

