package com.ndh1614.jsp_servlet_project_2505.controller;

import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;
import com.ndh1614.jsp_servlet_project_2505.service.FeePolicyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(urlPatterns = {"/fee/fee_policy_list"})
public class FeePolicyController extends HttpServlet {

    private final FeePolicyService feePolicyService = FeePolicyService.INSTANCE;

    // 요금 정책 리스트 조회
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("✅ doGet() 호출됨"); // ← 추가
        try {
            log.info("✅ doGet() 시작");
            List<FeePolicyVO> list = feePolicyService.getFeePolicies();
            //log.info("✅ 조회된 list: " + list);
            req.setAttribute("feePolicyList", list);
            req.getRequestDispatcher("/fee/fee_policy_list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("❌ 요금 정책 조회 중 오류 발생", e);  // 여기에 전체 에러 찍힘
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "요금 정책 조회 실패");
        }
    }
}
