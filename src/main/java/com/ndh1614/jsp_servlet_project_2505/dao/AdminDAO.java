package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.AdminVO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    private static AdminDAO instance;

    private AdminDAO() {
    }

    public static AdminDAO getInstance() {
        if (instance == null) {
            instance = new AdminDAO();
        }
        return instance;
    }
    public AdminVO selectMemberWithPasswdInAdmin(String adminId, String password) {
        String sql = "select * from admin where adminId = ? and password = ?";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, adminId);
            preparedStatement.setString(2, password);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return AdminVO.builder()
                        .adminId(resultSet.getString("adminId"))
                        .password(resultSet.getString(2))
                        .name(resultSet.getString(3))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public void updateAdmin(AdminVO admin , String oldAdminId) {
        String sql = "update admin set adminId = ?, name = ? , password = ? where adminId = ?";
        try {
            @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, admin.getAdminId());
            preparedStatement.setString(2, admin.getName());
            preparedStatement.setString(3, admin.getPassword());
            preparedStatement.setString(4, oldAdminId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
