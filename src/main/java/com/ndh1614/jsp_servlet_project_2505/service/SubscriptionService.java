package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.SubscriptionDAO;
import com.ndh1614.jsp_servlet_project_2505.util.SubscriptionChecker;

import java.time.LocalDate;

public enum SubscriptionService {
    INSTANCE;

    private final SubscriptionDAO subscriptionDAO;
    private final SubscriptionChecker subscriptionChecker;

    SubscriptionService() {
        subscriptionDAO = new SubscriptionDAO();
        subscriptionChecker = new SubscriptionChecker();
    }

    /**
     * 회원의 활성 정기권 여부 확인
     */
    public boolean isSubscriptionActive(int memberId) {
        LocalDate today = LocalDate.now();
        // DAO 직접 호출하거나 util을 통해 체크 가능
        // return subscriptionDAO.countActiveSubscriptions(memberId, today) > 0;

        // util 클래스 사용 예
        return subscriptionChecker.hasActiveSubscription(memberId, today);
    }
    // 추가적으로
    // 정기권 등록, 갱신, 만료 처리 메서드도 여기에 작성 가능
}
