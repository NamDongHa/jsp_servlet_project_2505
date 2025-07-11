package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.FeePolicyDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.CheckOutDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.ParkingDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.CheckOutVO;
import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingStatusVO;
import com.ndh1614.jsp_servlet_project_2505.dto.CheckOutDTO;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

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


    // 출차 시 요금 계산 및 업데이트
    public int processCheckout(String carId) {
        ParkingStatusVO vo = parkingDAO.selectNowCar(carId);
        if (vo == null || vo.getMemberVO() == null) {
            throw new IllegalArgumentException("차량 정보가 존재하지 않거나 회원 정보가 없습니다.");
        }

        FeePolicyVO policy = feePolicyDAO.selectPolicyByCarType(vo.getMemberVO().getType());

        return checkOutDAO.calculateAndUpdateFee(
                carId,
                policy,
                vo.getMemberVO().getType(),
                vo.getMemberVO().isMonthPay()
        );
    }
}
