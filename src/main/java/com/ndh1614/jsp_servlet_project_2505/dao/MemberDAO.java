package com.ndh1614.jsp_servlet_project_2505.dao;


import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void insertMember(MemberVO memberVO) { //회원가입
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

    public MemberVO selectMemberWithPasswd(String carId, String password) {
        String sql = "select * from member where carId = ? and password = ?";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            preparedStatement.setString(2, password);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return MemberVO.builder()
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
        return null;
    }public MemberVO selectMemberById(String carId) {
        String sql = "select * from member where carId = ?";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return MemberVO.builder()
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
        return null;
    }
    public void updateMember(MemberVO member , String oldCarId) {
        String sql = "update member set carId = ?, name = ? , password = ?, phone = ? , " +
                "type = ? , monthPay = ? where carId = ?";
        try {
            @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, member.getCarId());
            preparedStatement.setString(2, member.getName());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getPhone());
            preparedStatement.setString(5, member.getType());
            preparedStatement.setBoolean(6, member.isMonthPay());
            preparedStatement.setString(7, oldCarId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<MemberVO> selectMonthPayMembers(boolean monthPay) {
        String sql = "select * from member where monthPay = ?";
        List<MemberVO> members = new ArrayList<>();
        MemberVO member = null;
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, monthPay);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                member = MemberVO.builder()
                        .carId(resultSet.getString("carId"))
                        .password(resultSet.getString("password"))
                        .name(resultSet.getString("name"))
                        .phone(resultSet.getString("phone"))
                        .type(resultSet.getString("type"))
                        .monthPay(resultSet.getBoolean("monthPay"))
                        .build();
                members.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;
    }
    public List<MemberVO> selectAllMembers() {
        String sql = "select * from member";
        List<MemberVO> members = new ArrayList<>();
        MemberVO member = null;
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                member = MemberVO.builder()
                        .carId(resultSet.getString("carId"))
                        .password(resultSet.getString("password"))
                        .name(resultSet.getString("name"))
                        .phone(resultSet.getString("phone"))
                        .type(resultSet.getString("type"))
                        .monthPay(resultSet.getBoolean("monthPay"))
                        .build();
                members.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;
    }
    public void deleteMember(String carId) {
        String sql = "DELETE FROM member WHERE carId = ?";
        try {
            @Cleanup Connection con = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
