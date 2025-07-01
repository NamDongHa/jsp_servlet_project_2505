package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dto.ParkingStatusDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class ParkingServiceTest {
    private ParkingService parkingService;

    @BeforeEach
    void setUp() {
        parkingService = ParkingService.INSTANCE;
    }

    @Test
    void getParkingStatus() {
        ParkingStatusDTO parkingStatusDTO = parkingService.getParkingStatus("carId");
        System.out.println(parkingStatusDTO);
    }

    @Test
    void addCar() {
        parkingService.addCar("12가 9999");
    }

    @Test
    void isInCar() {
        log.info(parkingService.isInCar("12가 9999"));
    }

    @Test
    void currentCar() {
        log.info(parkingService.currentCar());
    }

    @Test
    void selectAll() {
        log.info(parkingService.selectAllParkingStatus());
    }
}