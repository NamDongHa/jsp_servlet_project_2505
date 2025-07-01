package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;
import com.ndh1614.jsp_servlet_project_2505.service.FeePolicyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/fee/insert")
public class InsertPolicyController extends HttpServlet {
    private final FeePolicyService feePolicyService = FeePolicyService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            FeePolicyVO feePolicyVO = FeePolicyVO.builder()
                    .timeType(req.getParameter("timeType"))
                    .baseTime(Integer.parseInt(req.getParameter("baseTime")))
                    .baseFee(Integer.parseInt(req.getParameter("baseFee")))
                    .unitTime(Integer.parseInt(req.getParameter("unitTime")))
                    .unitFee(Integer.parseInt(req.getParameter("unitFee")))
                    .dailyMaxFee(Integer.parseInt(req.getParameter("dailyMaxFee")))
                    .discountDisabled(Double.parseDouble(req.getParameter("discountDisabled")))
                    .discountCompact(Double.parseDouble(req.getParameter("discountCompact")))
                    .build();

            boolean success = feePolicyService.registerPolicy(feePolicyVO);

            if (success) {
                resp.sendRedirect(req.getContextPath() + "/fee/fee_policy_list");
            } else {
                resp.sendRedirect(req.getContextPath() + "/fee/form.jsp?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/fee/form.jsp?error=1");
        }
    }
}
