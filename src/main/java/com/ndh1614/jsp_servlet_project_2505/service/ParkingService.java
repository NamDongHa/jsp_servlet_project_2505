package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.ParkingDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingStatusVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.dto.ParkingDTO;
import com.ndh1614.jsp_servlet_project_2505.dto.ParkingStatusDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public enum ParkingService {
    INSTANCE, Collectors;

    private ParkingDAO parkingDAO;
    private ModelMapper modelMapper;

    ParkingService() {
        parkingDAO = new ParkingDAO();
        modelMapper = new ModelMapper();
    }


    // 조회
    public ParkingStatusDTO getParkingStatus(String carId) {

        // 1. dao에서 vo 들고옴
        ParkingStatusVO parkingStatusVO = parkingDAO.selectNowCar(carId);

        // 2. vo -> dto로 변경
        ParkingDTO parkingDTO = modelMapper.map(parkingStatusVO.getParkingVO(), ParkingDTO.class);
        MemberDTO memberDTO = modelMapper.map(parkingStatusVO.getMemberVO(), MemberDTO.class);

        // 3. dto를 반환
        return ParkingStatusDTO.builder()
                .parkingDTO(parkingDTO)
                .memberDTO(memberDTO)
                .build();
    }

    // member에 등록된 차량인지 확인
    public boolean isInCar(String carId) {
        return parkingDAO.existsMemberCar(carId);
    }

    // 주차 등록
    public void addCar(String carId) {

        parkingDAO.insertCar(carId);
    }

    // 주차된 차량 수 조회
    public int currentCar() {
        return parkingDAO.countCurrentParkingCars();
    }


    // 주차된 차량의 모든 정보를 가져옴
    public List<ParkingStatusVO> selectAllParkingStatus() {
        return parkingDAO.selectAllCurrentParkingStatus();
    }
}
