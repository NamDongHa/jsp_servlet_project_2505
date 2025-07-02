package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.OutTimeDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.ParkingDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.domain.OutTimeVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.dto.OutTimeDTO;
import org.modelmapper.ModelMapper;

public enum OutTimeService {
    INSTANCE, Collectors;

    private OutTimeDAO outTimeDAO;
    private ModelMapper modelMapper;

    OutTimeService() {
        outTimeDAO = new OutTimeDAO();
        modelMapper = new ModelMapper();
    }

    // outtime에 차량 등록
    public OutTimeDTO addOutCar(String carId){
        OutTimeVO outTimeVO = outTimeDAO.insertOutCar(carId);
        if (outTimeVO != null) {
            return modelMapper.map(outTimeVO, OutTimeDTO.class);
        }
        return null;
    }


}
