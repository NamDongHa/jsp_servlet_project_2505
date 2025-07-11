package com.ndh1614.jsp_servlet_project_2505.dao;

import org.junit.jupiter.api.Test;

class CheckOutDAOTest {
    CheckOutDAO checkOutDAO = new CheckOutDAO();
    @Test
    void insertOutCar() {
        String carId = "123";
        checkOutDAO.insertOutCar(carId);
    }
}