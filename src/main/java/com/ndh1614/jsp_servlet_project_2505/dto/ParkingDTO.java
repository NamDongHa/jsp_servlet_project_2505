package com.ndh1614.jsp_servlet_project_2505.dto;

import java.time.LocalDate;

public class ParkingDTO {
    private int spot; //남은 자리 개수
    private String carId; //차량번호
    private String name; //소유주
    private String phone; //휴대폰번호
    private LocalDate carIn; //입차시간
    private LocalDate carOut; //출차시간
    private String type; // 일반/겯차/장애인
    private boolean monthPay; //월정액
}
