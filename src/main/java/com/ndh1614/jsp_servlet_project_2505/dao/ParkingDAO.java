package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingStatusVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingVO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
                        .carInTime(resultSet.getTimestamp(2).toLocalDateTime())
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

    // member에 등록된 차량인지 확인 (member에 있으면 true 없으면 false)
    public boolean existsMemberCar(String carId) {
        String sql = "SELECT COUNT(*) FROM member WHERE carId = ?";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // 1개 이상이면 존재
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false; // 예외가 발생하거나 결과가 없으면 false
    }

    // 입차된 차량의 수 조회
    public int countCurrentParkingCars() {
        String sql = "SELECT COUNT(*) FROM parking";  // parking 테이블에 현재 입차된 차량 수 조회
        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    // 주차중인 차량의 전체 목록 조회
    public List<ParkingStatusVO> selectAllCurrentParkingStatus() {
        String sql = "SELECT p.carId, p.carInTime, m.type, m.monthPay " +
                "FROM parking p INNER JOIN member m ON p.carId = m.carId";

        List<ParkingStatusVO> list = new ArrayList<>();

        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                ParkingVO parkingVO = ParkingVO.builder()
                        .carId(rs.getString("carId"))
                        .carInTime(rs.getTimestamp("carInTime").toLocalDateTime())
                        .build();

                MemberVO memberVO = MemberVO.builder()
                        .type(rs.getString("type"))
                        .monthPay(rs.getBoolean("monthPay"))
                        .build();

                ParkingStatusVO parkingStatusVO = ParkingStatusVO.builder()
                        .parkingVO(parkingVO)
                        .memberVO(memberVO)
                        .build();

                list.add(parkingStatusVO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<ParkingStatusVO> selectLongTermParkingStatus() {
        List<ParkingStatusVO> list = new ArrayList<>();

        String sql = """
                    SELECT p.carId, p.carInTime,
                           m.type, m.monthPay
                    FROM parking p
                    LEFT JOIN member m ON p.carId = m.carId
                    WHERE TIMESTAMPDIFF(HOUR, p.carInTime, NOW()) >= 48
                    ORDER BY p.carInTime ASC
                """;

        try (Connection conn = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ParkingVO parkingVO = ParkingVO.builder()
                        .carId(rs.getString("carId"))
                        .carInTime(rs.getTimestamp("carInTime").toLocalDateTime())
                        .build();

                MemberVO memberVO = MemberVO.builder()
                        .type(rs.getString("type"))
                        .monthPay(rs.getBoolean("monthPay"))
                        .build();

                ParkingStatusVO statusVO = ParkingStatusVO.builder()
                        .parkingVO(parkingVO)
                        .memberVO(memberVO)
                        .build();

                list.add(statusVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // parking에 등록된 차량인지 확인
    public boolean isInParking(String carId) {
        String sql = "SELECT COUNT(*) FROM parking WHERE carId = ?";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // 1개 이상이면 존재
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false; // 예외가 발생하거나 결과가 없으면 false
    }

    // parking에 등록된 차량 삭제
    public void deleteCar(String carId) {
        String sql = "DELETE FROM parking WHERE carId = ?";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // parking에 이미 입차된 차량인지 확인
    // 차량이 이미 입차되어 있는지 확인
    public boolean isAlreadyParked(String carId) {
        String sql = "SELECT COUNT(*) FROM parking WHERE carId = ?";

        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carId);
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // parking에 등록되어있는 차량의 수를 반환하는 메서드
    public int countCarNum() {
        String sql = "SELECT COUNT(*) FROM parking";
        int count = 0;

        try (
                Connection conn = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

}
