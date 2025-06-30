package com.ndh1614.jsp_servlet_project_2505.dao;


import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import lombok.Cleanup;

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

    public void updateMember(String mid, String uuid) {
        String sql = "update tbl_member set uuid = ? where mid=?";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            preparedStatement.setString(2, mid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
