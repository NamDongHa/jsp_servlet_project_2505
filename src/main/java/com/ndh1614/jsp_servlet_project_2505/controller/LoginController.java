package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

@WebServlet(urlPatterns = {"/member/login"})  // 요청 URL 패턴
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글 깨짐 방지
        req.setCharacterEncoding("UTF-8");

        // 파라미터 받기
        String carId = req.getParameter("carId");
        String password = req.getParameter("password");

        // DAO로 인증 시도
        MemberDAO memberDAO = MemberDAO.getInstance();
        MemberVO member = memberDAO.selectMemberWithPasswd(carId, password);

        if (member != null) {
            // 인증 성공
            HttpSession session = req.getSession();
            session.setAttribute("member", member);
            session.setAttribute("isAuth", true);
            session.setAttribute("sessionCarId", carId);
            session.setAttribute("sessionMemberName", member.getName());

            // 메인 페이지로 리다이렉트 (msg=2 는 로그인 성공 메시지 용도인 듯)
            resp.sendRedirect(req.getContextPath() + "/main/main.jsp?msg=2");
        } else {
            // 인증 실패 - 로그인 페이지로 에러코드 넘겨서 이동
            resp.sendRedirect(req.getContextPath() + "/member/login.jsp?error=1");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 방식으로도 로그인 페이지로 이동 가능하게 처리
        resp.sendRedirect(req.getContextPath() + "/member/login.jsp");
    }
}
