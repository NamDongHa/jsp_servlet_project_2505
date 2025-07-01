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

@Log4j2
@WebServlet(value = "/pages/CarInServlet")
public class CarInController extends HttpServlet {
    private final ParkingService parkingService = ParkingService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("CarInServlet - doPost");

        String carId = req.getParameter("carId");
        log.info("입차 요청 차량번호: {}", carId);

        // 1. 주차장 만차 여부 확인
        int currentCount = parkingService.currentCar();
        if (currentCount >= 10) {
            req.setAttribute("error", "🚗 현재 주차장이 만차입니다. 입차가 불가능합니다.");
            req.getRequestDispatcher("/pages/parkingError.jsp").forward(req, resp);
            return;
        }

        // 2. 회원 등록 여부 확인
        boolean isMemberCar = parkingService.isInCar(carId);
        if (!isMemberCar) {
            req.setAttribute("error", "🚫 등록되지 않은 차량입니다. 입차가 불가능합니다.");
            req.getRequestDispatcher("/pages/parkingError.jsp").forward(req, resp);
            return;
        }

        // 3. 입차 처리 및 상태 조회
        parkingService.addCar(carId);  // 입차 처리
        ParkingStatusDTO parkingStatusDTO = parkingService.getParkingStatus(carId); // 입차된 차량의 상태

        req.setAttribute("parkingStatusDTO", parkingStatusDTO);
        log.info("입차 완료 - 상태 DTO: {}", parkingStatusDTO);

        // 4. 입차 결과 페이지로 이동
        req.getRequestDispatcher("/pages/parkingStatus.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST 요청만 처리하도록 제한
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST 방식으로 요청해 주세요.");
    }
}
