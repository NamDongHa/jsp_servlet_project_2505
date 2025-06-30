package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingStatusVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.time.LocalDate;

@Log4j2
public class ParkingDAO {

    // 차량 입차 등록
    public void insertCar(String carId) {
        String sql = "INSERT INTO parking(carId) VALUES (?) ";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 실시간 주차 현황
    public ParkingStatusVO selectNowCar(String carId) {
        String sql = "SELECT p.carId, p.carInTime, m.type, m.monthPay FROM parking p " +
                "inner join member m on p.carId = m.carId WHERE m.carId = ?";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ParkingVO parkingVO = ParkingVO.builder()
                        .carId(resultSet.getString(1))
                        .carInTime(LocalDate.from(resultSet.getTimestamp(2).toLocalDateTime()))
                        .build();

                MemberVO memberVO = MemberVO.builder()
                        .type(resultSet.getString(3))
                        .monthPay(resultSet.getBoolean(4))
                        .build();

                return ParkingStatusVO.builder()
                        .parkingVO(parkingVO)
                        .memberVO(memberVO)
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
