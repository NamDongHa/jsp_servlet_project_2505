package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/memberModify"})
public class ModifyMemberInListController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 수정된 데이터 수집
        String oldCarId = req.getParameter("oldCarId"); // 수정 전 carId
        String carId = req.getParameter("carId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String type = req.getParameter("type");
        boolean monthPay = req.getParameter("monthPay") != null;

        MemberDTO memberDTO = MemberDTO.builder()
                .carId(carId)
                .name(name)
                .phone(phone)
                .password(password)
                .type(type)
                .monthPay(monthPay)
                .build();

        // 서비스 호출
        MemberService memberService = MemberService.INSTANCE;
        memberService.updateInList(memberDTO, oldCarId);

        // 리다이렉트
        resp.sendRedirect(req.getContextPath() + "/pages/memberList.jsp");
    }
}

