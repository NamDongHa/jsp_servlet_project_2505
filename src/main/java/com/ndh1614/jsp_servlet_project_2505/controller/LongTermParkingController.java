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
import java.util.List;

@Log4j2
@WebServlet(urlPatterns = {"/pages/longParking"})
public class LongTermParkingController extends HttpServlet {
    private final ParkingService parkingService = ParkingService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet 호출됨");
        try{
            log.info("doGet() 시작");
        // 1. 서비스에서 장기 주차 차량 리스트 조회
        List<ParkingStatusDTO> longTermList = parkingService.getLongTermParkingList();
        // 2. 조회 결과를 request 속성에 저장
        request.setAttribute("longTermList", longTermList);
        // 3. JSP 포워딩 (예: /WEB-INF/views/parking/long_term_parking.jsp)
        request.getRequestDispatcher("/pages/longParking.jsp").forward(request, response);
        } catch (ServletException e) {
            log.error("❌ 전송중 오류발생", e);  // 여기에 전체 에러 찍힘
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "장기 주차 차량 조회 실패");
        }
    }
}
