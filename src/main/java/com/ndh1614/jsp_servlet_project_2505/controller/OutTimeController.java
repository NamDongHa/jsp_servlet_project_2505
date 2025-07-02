package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.AdminVO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.ParkingStatusDTO;
import com.ndh1614.jsp_servlet_project_2505.service.OutTimeService;
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
@WebServlet(value = "/pages/CarOutServlet")
public class OutTimeController extends HttpServlet {
    private final ParkingService parkingService = ParkingService.INSTANCE;
    private final OutTimeService outTimeService = OutTimeService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("CarOutServlet - doPost");

        MemberDAO memberDAO = MemberDAO.getInstance();
        // 로그인 여부 확인
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("isAuth") == null) {
            log.info("로그인되지 않은 사용자 요청");
            resp.sendRedirect(req.getContextPath() + "/member/login.jsp");
            return;
        }

        String carId = req.getParameter("carId");
        log.info("출차 요청 차량번호: {}", carId);

       if(session.getAttribute("isAdmin") != null) {
           // 2. 출차 처리 및 상태 조회
           outTimeService.addOutCar(carId);  // 출차 처리(outTime에 출차된 차량정보 등록)
           parkingService.removeCar(carId); // 출차 처리(parking에 carId가 같은 차량 삭제)

           // 3. 입차 결과 페이지로 이동
           req.getRequestDispatcher("/pages/parkingStatus.jsp").forward(req, resp);
           return;
       }
            // 로그인된 회원 정보에서 차량번호 가져오기
        MemberVO loginUser = (MemberVO) session.getAttribute("member");
        String sessionCarId = loginUser.getCarId();  // 또는 loginUser.getId(), loginUser.getCarNumber() 등 실제 필드명에 맞춰 수정

        // 1. 로그인한 사용자 차량인지 확인
        if (!carId.equals(sessionCarId)) {
            req.getRequestDispatcher("/pages/carOut.jsp").forward(req, resp);
            return;
        }
        // 2. 출차 처리 및 상태 조회
        outTimeService.addOutCar(carId);  // 출차 처리(outTime에 출차된 차량정보 등록)
        parkingService.removeCar(carId); // 출차 처리(parking에 carId가 같은 차량 삭제)

        // 3. 입차 결과 페이지로 이동
        req.getRequestDispatcher("/pages/parkingStatus.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // POST 요청만 처리하도록 제한
        resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST 방식으로 요청해 주세요.");
    }

}
