package com.ndh1614.jsp_servlet_project_2505.util;

import com.ndh1614.jsp_servlet_project_2505.dao.SubscriptionDAO;

import java.time.LocalDate;

public class SubscriptionChecker {

    private final SubscriptionDAO subscriptionDAO;

    public SubscriptionChecker() {
        this.subscriptionDAO = new SubscriptionDAO();
    }

    public boolean hasActiveSubscription(int memberId, LocalDate today) {
        // DAO 메서드를 호출해 유효한 정기권 개수 조회
        int count = subscriptionDAO.countActiveSubscriptions(memberId, today);
        return count > 0;
    }
}
