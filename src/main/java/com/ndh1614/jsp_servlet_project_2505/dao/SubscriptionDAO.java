package com.ndh1614.jsp_servlet_project_2505.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SubscriptionDAO {

    /**
     * 회원의 활성 정기권 개수 조회
     * @param memberId 회원 ID
     * @param date 조회 기준일 (오늘 날짜)
     * @return 활성 정기권 개수
     */
    public int countActiveSubscriptions(int memberId, LocalDate date) {
        String sql = "SELECT COUNT(*) FROM subscription WHERE memberId = ? AND status = 'active' AND startDate <= ? AND endDate >= ?";
        try (
                Connection connection = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setInt(1, memberId);
            ps.setDate(2, java.sql.Date.valueOf(date));
            ps.setDate(3, java.sql.Date.valueOf(date));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
