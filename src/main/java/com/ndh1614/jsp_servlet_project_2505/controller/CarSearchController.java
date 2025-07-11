package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.ParkingStatusDTO;
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
@WebServlet(value = "/pages/CarSearchServlet")
public class CarSearchController extends HttpServlet {
    private final ParkingService parkingService = ParkingService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet");

        String carId = req.getParameter("carId");

        // 로그인 여부 확인
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("isAuth") == null) {
            log.info("로그인되지 않은 사용자 요청");
            alertAndRedirect(resp, "로그인 먼저 해주세요.", req.getContextPath() + "/member/login.jsp");
            return;
        }

        // 로그인된 회원 정보에서 차량번호 가져오기
        MemberVO loginUser = (MemberVO) session.getAttribute("member");
        String sessionCarId = loginUser.getCarId();

        // 1. 로그인한 사용자 차량인지 확인
        if (!carId.equals(sessionCarId)) {
            alertAndRedirect(resp, "차량번호가 일치하지 않습니다. 다시 입력해주세요.",
                    req.getContextPath() + "/pages/carSearch.jsp");
            return;
        }

        // 2. 주차 상태 조회
        ParkingStatusDTO parkingStatusDTO = parkingService.getParkingStatus(carId);

        if (parkingStatusDTO == null) {
            alertAndRedirect(resp, "해당 차량의 주차 정보가 없습니다.",
                    req.getContextPath() + "/pages/carSearch.jsp");
            return;
        }

        req.setAttribute("parkingStatusDTO", parkingStatusDTO);
        log.info(parkingStatusDTO);
        req.getRequestDispatcher("/pages/carResult.jsp").forward(req, resp);
    }

    private void alertAndRedirect(HttpServletResponse resp, String message, String redirectUrl) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<script>");
        resp.getWriter().println("alert('" + message + "');");
        resp.getWriter().println("location.href='" + redirectUrl + "';");
        resp.getWriter().println("</script>");
        resp.getWriter().flush();
    }
}
