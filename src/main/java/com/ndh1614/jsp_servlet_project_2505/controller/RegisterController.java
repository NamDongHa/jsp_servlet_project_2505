package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(urlPatterns = {"/member/register"})  // 요청 URL 패턴
public class RegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setCharacterEncoding("UTF-8");

  MemberDTO memberDTO = MemberDTO.builder()
          .carId(req.getParameter("carId"))
          .name(req.getParameter("name"))
          .type(req.getParameter("carType"))
          .phone(req.getParameter("phone"))
          .password(req.getParameter("password"))
          .build();

  MemberService memberService = MemberService.INSTANCE;
  memberService.register(memberDTO);

  resp.sendRedirect("../main/main.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // GET 방식으로도 로그인 페이지로 이동 가능하게 처리
        resp.sendRedirect(req.getContextPath() + "/member/register.jsp");
    }
}
