package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.FeePolicyDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.CheckOutDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.ParkingDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.CheckOutVO;
import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingStatusVO;
import com.ndh1614.jsp_servlet_project_2505.dto.CheckOutDTO;
import com.ndh1614.jsp_servlet_project_2505.util.ParkingFeeCalculator;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Log4j2
public enum CheckOutService {
    INSTANCE;

    private final CheckOutDAO checkOutDAO;
    private final ParkingDAO parkingDAO;
    private final FeePolicyDAO feePolicyDAO;
    private final ModelMapper modelMapper;

    CheckOutService() {
        checkOutDAO = new CheckOutDAO();
        parkingDAO = new ParkingDAO();            // 누락된 부분 1
        feePolicyDAO = new FeePolicyDAO();        // 누락된 부분 2
        modelMapper = new ModelMapper();
    }

    // 출차 시 checkout 테이블에 등록
    public CheckOutDTO addOutCar(String carId) {
        // DAO에서 반환하는 건 VO이므로 VO 타입으로 먼저 받기
        CheckOutVO checkOutVO = checkOutDAO.insertOutCar(carId);

        if (checkOutVO != null) {
            // VO → DTO 변환
            return modelMapper.map(checkOutVO, CheckOutDTO.class);
        }
        return null;
    }


    public int processCheckout(String carId) {
        ParkingStatusVO vo = parkingDAO.selectNowCar(carId);
        if (vo == null || vo.getMemberVO() == null) {
            throw new IllegalArgumentException("차량 정보가 존재하지 않거나 회원 정보가 없습니다.");
        }

        String carType = vo.getMemberVO().getType();
        FeePolicyVO policy = feePolicyDAO.selectPolicyByCarType(carType);
        log.info("조회된 요금 정책: {}", policy);

        if (policy == null) {
            throw new RuntimeException("요금 정책을 찾을 수 없습니다. carType=" + carType);
        }

        return checkOutDAO.calculateAndUpdateFee(
                carId,
                policy,
                carType,
                vo.getMemberVO().isMonthPay()
        );
    }
}
