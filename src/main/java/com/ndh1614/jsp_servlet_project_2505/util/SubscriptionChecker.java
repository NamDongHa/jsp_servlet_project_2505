package com.ndh1614.jsp_servlet_project_2505.util;

import com.ndh1614.jsp_servlet_project_2505.dao.SubscriptionDAO;

import java.time.LocalDate;

public class SubscriptionChecker {

    private final SubscriptionDAO subscriptionDAO;

    public SubscriptionChecker() {
        this.subscriptionDAO = new SubscriptionDAO();
    }

    /**
     * 회원이 현재 유효한 정기권을 가지고 있는지 확인
     * @param memberId 회원 ID
     * @param today 검사 기준일 (보통 LocalDate.now())
     * @return 정기권이 활성 상태면 true, 아니면 false
     */
    public boolean hasActiveSubscription(int memberId, LocalDate today) {
        // DAO 메서드를 호출해 유효한 정기권 개수 조회
        int count = subscriptionDAO.countActiveSubscriptions(memberId, today);
        return count > 0;
    }
}
