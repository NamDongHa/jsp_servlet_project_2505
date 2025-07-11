package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeePolicyDAO {
    public List<FeePolicyVO> selectFeePolicies() {
        String sql = "SELECT * FROM feepolicy";
        List<FeePolicyVO> policies = new ArrayList<>();
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement ps = connection.prepareStatement(sql);
            @Cleanup ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FeePolicyVO policy = FeePolicyVO.builder()
                        .no(rs.getInt("no"))
                        .timeType(rs.getString("timeType"))
                        .baseTime(rs.getInt("baseTime"))
                        .baseFee(rs.getInt("baseFee"))
                        .unitTime(rs.getInt("unitTime"))
                        .unitFee(rs.getInt("unitFee"))
                        .dailyMaxFee(rs.getInt("dailyMaxFee"))
                        .discountDisabled(rs.getDouble("discountDisabled"))
                        .discountCompact(rs.getDouble("discountCompact"))
                        .build();
                policies.add(policy);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return policies;
    }

    public boolean insertPolicy(FeePolicyVO feePolicyVO) {
        String sql = "INSERT INTO feepolicy (timeType, baseTime, baseFee, unitTime, unitFee, dailyMaxFee, discountDisabled, discountCompact, carType) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, feePolicyVO.getTimeType());
            ps.setInt(2, feePolicyVO.getBaseTime());
            ps.setInt(3, feePolicyVO.getBaseFee());
            ps.setInt(4, feePolicyVO.getUnitTime());
            ps.setInt(5, feePolicyVO.getUnitFee());
            ps.setInt(6, feePolicyVO.getDailyMaxFee());
            ps.setDouble(7, feePolicyVO.getDiscountDisabled());
            ps.setDouble(8, feePolicyVO.getDiscountCompact());
            ps.setString(9, feePolicyVO.getCarType());
            ps.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public FeePolicyVO selectPolicyByCarType(String carType) {
        String sql = "SELECT * FROM feepolicy WHERE carType = ? LIMIT 1";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, carType);
            @Cleanup ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return FeePolicyVO.builder()
                        .no(rs.getInt("no"))
                        .timeType(rs.getString("timeType"))
                        .baseTime(rs.getInt("baseTime"))
                        .baseFee(rs.getInt("baseFee"))
                        .unitTime(rs.getInt("unitTime"))
                        .unitFee(rs.getInt("unitFee"))
                        .dailyMaxFee(rs.getInt("dailyMaxFee"))
                        .discountDisabled(rs.getDouble("discountDisabled"))
                        .discountCompact(rs.getDouble("discountCompact"))
                        .carType(rs.getString("carType"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
