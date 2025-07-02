package com.ndh1614.jsp_servlet_project_2505.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutTimeServiceTest {
    OutTimeService outTimeService;

    @BeforeEach
    void setUp() {
        outTimeService = OutTimeService.INSTANCE;
    }

    @Test
    void addOutCarTest() {
        String carId = "3333";
        outTimeService.addOutCar(carId);
    }
}