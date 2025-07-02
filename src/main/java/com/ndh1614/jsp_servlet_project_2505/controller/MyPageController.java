package com.ndh1614.jsp_servlet_project_2505.controller;


import com.ndh1614.jsp_servlet_project_2505.dao.AdminDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.AdminVO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/member/myPage"})  // 요청 URL 패턴
public class MyPageController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        MemberDAO memberDAO = MemberDAO.getInstance();
        AdminDAO adminDAO = AdminDAO.getInstance();
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        AdminVO adminVO = (AdminVO) session.getAttribute("member2");
        if (memberVO != null) {
            String oldCarId = memberVO.getCarId();
            memberVO = MemberVO.builder()
                    .carId(req.getParameter("carId"))
                    .name(req.getParameter("name"))
                    .type(req.getParameter("type"))
                    .phone(req.getParameter("phone"))
                    .monthPay(req.getParameter("monthPay") != null)
                    .password(req.getParameter("password"))
                    .build();
            memberDAO.updateMember(memberVO, oldCarId);
            session.setAttribute("member", memberVO);
        } else{
            String oldAdminId = adminVO.getAdminId();
            adminVO = AdminVO.builder()
                    .adminId(req.getParameter("carId"))
                    .name(req.getParameter("name"))
                    .password(req.getParameter("password"))
                    .build();
        adminDAO.updateAdmin(adminVO, oldAdminId);
        session.setAttribute("member2", adminVO);
        }
        resp.sendRedirect("../main/main.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 방식으로도 로그인 페이지로 이동 가능하게 처리
        resp.sendRedirect(req.getContextPath() + "/member/myPage.jsp");
    }
}
