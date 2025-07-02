package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.ParkingStatusVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class ParkingDAOTest {
    ParkingDAO parkingDAO = new ParkingDAO();

    @Test
    void insertCar() {

        parkingDAO.insertCar("carId");
    }

    @Test
    void selectNowCar() {

        ParkingStatusVO parkingStatusVO = parkingDAO.selectNowCar("42");
        System.out.println(parkingStatusVO);
    }

    @Test
    void isExistCar() {

        log.info(parkingDAO.existsMemberCar("1212"));
    }

    @Test
    void countCar() {
        log.info(parkingDAO.countCurrentParkingCars());
    }

    @Test
    void allCarIn() {
        log.info(parkingDAO.selectAllCurrentParkingStatus());
    }

    @Test
    void isInCarTest() {
        log.info(parkingDAO.isInParking("carId"));
    }

    @Test
    void isAlreadyInCarTest() {
        log.info(parkingDAO.isInParking("44"));
    }
    @Test
    void selectLongParking() {
        List<ParkingStatusVO> parkingVOS = parkingDAO.selectLongTermParkingStatus();
        parkingVOS.forEach(System.out::println);
    }

    @Test
    void countCarNum() {
        log.info(parkingDAO.countCarNum());
    }
}