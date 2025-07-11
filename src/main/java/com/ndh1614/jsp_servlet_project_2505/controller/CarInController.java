package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.domain.AdminVO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.AdminDTO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.dto.ParkingStatusDTO;
import com.ndh1614.jsp_servlet_project_2505.service.MemberService;
import com.ndh1614.jsp_servlet_project_2505.service.ParkingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebServlet(value = "/pages/CarInServlet")
public class CarInController extends HttpServlet {
    private final ParkingService parkingService = ParkingService.INSTANCE;
    private final MemberService memberService = MemberService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("CarInServlet - doPost");

        // 로그인 여부 확인
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("isAuth") == null) {
            log.info("로그인되지 않은 사용자 요청");
            resp.sendRedirect(req.getContextPath() + "/member/login.jsp");
            return;
        }

        MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("member2");
        // 로그인된 회원 정보 가져오기
        // 입력값 받기
        String carId = req.getParameter("carId");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String type = req.getParameter("type");
        boolean monthPay = req.getParameter("monthPay") != null;


        // 1. 주차장 만차 여부 확인
        int currentCount = parkingService.currentCar();
        if (currentCount >= 10) {
            req.getRequestDispatcher("/pages/carIn.jsp").forward(req, resp);
            return;
        }

        // 2. 회원 정보 일치 여부 확인
        boolean isMatching = memberService.isMatching(
                carId,
                name,
                phone,
                type,
                monthPay
        );

        if (!isMatching) {
            req.getRequestDispatcher("/pages/carIn.jsp").forward(req, resp);
            return;
        }

        // 💡 이미 입차된 차량인지 확인
        if (parkingService.carInAlready(carId)) {
            req.getRequestDispatcher("/pages/carIn.jsp").forward(req, resp);
            return;
        }
        if (session.getAttribute("isAdmin") != null) {
            parkingService.addCar(carId);  // 입차 처리
            ParkingStatusDTO parkingStatusDTO = parkingService.getParkingStatus(carId); // 입차된 차량의 상태

            req.setAttribute("parkingStatusDTO", parkingStatusDTO);
            log.info("입차 완료 - 상태 DTO: {}", parkingStatusDTO);

            // 4. 입차 결과 페이지로 이동
            req.getRequestDispatcher("/pages/parkingStatus.jsp").forward(req, resp);
        }
        log.info("입차 요청 차량번호: {}", carId);
        if (!memberDTO.getCarId().equals(carId)) {
            req.getRequestDispatcher("/pages/carIn.jsp").forward(req, resp);
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
