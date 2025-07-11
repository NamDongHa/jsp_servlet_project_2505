package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.service.CheckOutService;
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
@WebServlet("/checkout")
public class CheckOutController extends HttpServlet {

    private final CheckOutService checkOutService = CheckOutService.INSTANCE;
    private final ParkingService parkingService = ParkingService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("출차 컨트롤러 도착");

        // 로그인 여부 확인
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("isAuth") == null) {
            log.info("로그인되지 않은 사용자 요청");
            req.setAttribute("errorMessage", "로그인 먼저 해주세요.");
            req.getRequestDispatcher("/member/login.jsp").forward(req, resp);
            return;
        }

        String carId = req.getParameter("carId");
        log.info("출차 요청 차량번호: {}", carId);
        if(session.getAttribute("isAdmin") != null) {
            try {
                int fee = checkOutService.processCheckout(carId);
                log.info("출차 요금 계산 완료: {}원", fee);

                req.setAttribute("carId", carId);
                req.setAttribute("fee", fee);

                // 2. 출차 처리 및 상태 조회
                checkOutService.addOutCar(carId);  // 출차 처리(outTime에 출차된 차량정보 등록)
                parkingService.removeCar(carId); // 출차 처리(parking에 carId가 같은 차량 삭제)

                // 3. 입차 결과 페이지로 이동
                req.getRequestDispatcher("/pages/checkout_result.jsp").forward(req, resp);
                return;
            } catch (Exception e) {
                log.error("출차 처리 중 오류 발생", e);
                req.setAttribute("error", "출차 처리 중 오류가 발생했습니다.");
                req.getRequestDispatcher("/pages/carOut.jsp").forward(req, resp);
                return;
            }
        }
        // 로그인된 회원 정보에서 차량번호 가져오기
        MemberDTO loginUser = (MemberDTO) session.getAttribute("member");
        String sessionCarId = loginUser.getCarId();  // 또는 loginUser.getId(), loginUser.getCarNumber() 등 실제 필드명에 맞춰 수정

        if (carId == null || carId.isBlank()) {
            req.setAttribute("error", "차량 번호가 유효하지 않습니다.");
            req.getRequestDispatcher("/pages/carOut.jsp").forward(req, resp);
            return;
        }

        // 1. 로그인한 사용자 차량인지 확인
        if (!carId.equals(sessionCarId)) {
            req.setAttribute("errorMessage", "차량번호가 일치하지 않습니다. 다시 입력해주세요."); // 여기
            req.getRequestDispatcher("/pages/carOut.jsp").forward(req, resp);
            return;
        }

        log.info("출차 차량번호: {}", carId);

        try {
            int fee = checkOutService.processCheckout(carId);
            log.info("출차 요금 계산 완료: {}원", fee);

            req.setAttribute("carId", carId);
            req.setAttribute("fee", fee);

            // 2. 출차 처리 및 상태 조회
            checkOutService.addOutCar(carId);  // 출차 처리(outTime에 출차된 차량정보 등록)
            parkingService.removeCar(carId); // 출차 처리(parking에 carId가 같은 차량 삭제)

            // 3. 입차 결과 페이지로 이동
            req.getRequestDispatcher("/pages/checkout_result.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("출차 처리 중 오류 발생", e);
            req.setAttribute("error", "출차 처리 중 오류가 발생했습니다.");
            req.getRequestDispatcher("/pages/checkout_result.jsp").forward(req, resp);
        }
    }
}
