package com.ndh1614.jsp_servlet_project_2505.dao;


import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import lombok.Cleanup;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    public void insertMember(MemberVO memberVO) {
        String sql = "insert into member (carId, name, password, phone, type, monthPay) values(? ,? ,?,?,?,?)";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberVO.getCarId());
            preparedStatement.setString(2, memberVO.getName());
            preparedStatement.setString(3, memberVO.getPassword());
            preparedStatement.setString(4, memberVO.getPhone());
            preparedStatement.setString(5, memberVO.getType());
            preparedStatement.setBoolean(6, memberVO.isMonthPay());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // carId로 차량 정보 검색
    public MemberVO selectMember(String carId) {
        String sql = "select * from member where carId = ?";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                MemberVO memberVO = MemberVO.builder()
                        .carId(resultSet.getString(1))
                        .name(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .phone(resultSet.getString(4))
                        .type(resultSet.getString(5))
                        .monthPay(resultSet.getBoolean(6))
                        .build();
                return memberVO;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
