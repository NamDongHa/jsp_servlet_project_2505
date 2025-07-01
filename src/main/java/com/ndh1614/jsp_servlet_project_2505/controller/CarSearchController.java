package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.dto.ParkingStatusDTO;
import com.ndh1614.jsp_servlet_project_2505.service.ParkingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet(value = "/pages/CarSearchServlet")
public class CarSearchController extends HttpServlet {
    private final ParkingService parkingService = ParkingService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet");
        ParkingStatusDTO parkingStatusDTO = parkingService.getParkingStatus(req.getParameter("carId"));

        req.setAttribute("parkingStatusDTO", parkingStatusDTO);
        log.info(parkingStatusDTO);
        req.getRequestDispatcher("/pages/carResult.jsp").forward(req, resp);
    }
}