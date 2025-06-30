package com.ndh1614.jsp_servlet_project_2505.dao;


import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    private static MemberDAO instance;

    private MemberDAO() {
    }

    public static MemberDAO getInstance() {
        if (instance == null) {
            instance = new MemberDAO();
        }
        return instance;
    }
    public void insertMember(MemberDTO memberDTO) { //회원가입
        String sql = "insert into member (carId, name, password, phone, type, monthPay) values(? ,? ,?,?,?,?)";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberDTO.getCarId());
            preparedStatement.setString(2, memberDTO.getName());
            preparedStatement.setString(3, memberDTO.getPassword());
            preparedStatement.setString(4, memberDTO.getPhone());
            preparedStatement.setString(5, memberDTO.getType());
            preparedStatement.setBoolean(6, memberDTO.isMonthPay());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MemberDTO findMemberWithPasswd(String carId, String password) {
        String sql = "select * from member where carId = ? and password = ?";
        MemberDTO member = null;
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            preparedStatement.setString(2, password);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                member = MemberDTO.builder()
                        .carId(resultSet.getString("carId"))
                        .password(resultSet.getString(2))
                        .name(resultSet.getString(3))
                        .phone(resultSet.getString(4))
                        .type(resultSet.getString(5))
                        .monthPay(resultSet.getBoolean(6))
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return member;
    }
}
