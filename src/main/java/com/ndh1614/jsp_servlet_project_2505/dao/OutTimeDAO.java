package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.OutTimeVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OutTimeDAO {

    // 출차 처리(outtime에 추가)
    public OutTimeVO insertOutCar(String carId) {
        String sql = "INSERT INTO outtime(carId) VALUES (?)";
        try {
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, carId);
            pstmt.executeUpdate();

            // INSERT 후 해당 carId에 대한 OutTimeVO 객체를 바로 생성해서 반환
            return OutTimeVO.builder()
                    .carId(carId)
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
