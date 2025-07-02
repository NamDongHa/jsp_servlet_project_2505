package com.ndh1614.jsp_servlet_project_2505.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutTimeDAOTest {
    OutTimeDAO outTimeDAO = new OutTimeDAO();
    @Test
    void insertOutCar() {
        String carId = "2222";
        outTimeDAO.insertOutCar(carId);
    }
}