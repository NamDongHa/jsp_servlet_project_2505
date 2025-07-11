package com.ndh1614.jsp_servlet_project_2505.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckOutServiceTest {
    CheckOutService checkOutService;

    @BeforeEach
    void setUp() {
        checkOutService = CheckOutService.INSTANCE;
    }

    @Test
    void addOutCarTest() {
        String carId = "3333";
        checkOutService.addOutCar(carId);
    }
}