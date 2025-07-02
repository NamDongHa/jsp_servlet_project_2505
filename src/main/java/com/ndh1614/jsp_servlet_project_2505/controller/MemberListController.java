package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/memberDelete"})
public class MemberListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        MemberDAO dao = MemberDAO.getInstance();

        dao.deleteMember(id);
        resp.sendRedirect(req.getContextPath() + "/pages/memberList.jsp");
    }
}
