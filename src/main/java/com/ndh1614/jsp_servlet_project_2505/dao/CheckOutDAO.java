package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.CheckOutVO;
import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;

import com.ndh1614.jsp_servlet_project_2505.util.ParkingFeeCalculator;
import lombok.Cleanup;

import java.sql.*;
import java.time.LocalDateTime;

public class CheckOutDAO {
    // 출차 처리(outtime에 추가)
    public CheckOutVO insertOutCar(String carId) {
        String sql = "INSERT INTO checkout(carId) VALUES (?)";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, carId);
            preparedStatement.executeUpdate();

            // INSERT 후 해당 carId에 대한 OutTimeVO 객체를 바로 생성해서 반환
            return CheckOutVO.builder()
                    .carId(carId)
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int calculateAndUpdateFee(String carId, FeePolicyVO policy, String carType, boolean isMonthly) {
        String sql = """
        SELECT p.CarInTime, o.CarOutTime
        FROM parking p
        LEFT JOIN checkout o ON p.carId = o.carId
        WHERE p.carId = ?
    """;

        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, carId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    LocalDateTime inTime = rs.getTimestamp("CarInTime").toLocalDateTime();
                    Timestamp outTimestamp = rs.getTimestamp("CarOutTime");
                    LocalDateTime outTime = (outTimestamp != null) ? outTimestamp.toLocalDateTime() : LocalDateTime.now();

                    ParkingFeeCalculator calculator = new ParkingFeeCalculator(policy);
                    int fee = calculator.calculateFee(inTime, outTime, carType, isMonthly);

                    // 출차 시간이 없으면 지금 시간으로 업데이트, 요금도 업데이트
                    if (outTimestamp == null) {
                        String updateSql = "UPDATE checkout SET CarOutTime = ?, parkingFee = ? WHERE carId = ?";
                        try (PreparedStatement updatePstmt = conn.prepareStatement(updateSql)) {
                            updatePstmt.setTimestamp(1, Timestamp.valueOf(outTime));
                            updatePstmt.setInt(2, fee);
                            updatePstmt.setString(3, carId);
                            updatePstmt.executeUpdate();
                        }
                    } else {
                        // 출차시간이 이미 있으면 요금만 업데이트
                        String updateSql = "UPDATE checkout SET parkingFee = ? WHERE carId = ?";
                        try (PreparedStatement updatePstmt = conn.prepareStatement(updateSql)) {
                            updatePstmt.setInt(1, fee);
                            updatePstmt.setString(2, carId);
                            updatePstmt.executeUpdate();
                        }
                    }
                    return fee;
                } else {
                    // 해당 차량 입차 기록 없음
                    throw new IllegalArgumentException("차량 입차 기록이 존재하지 않습니다.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
