package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.dao.ParkingDAO;
import org.modelmapper.ModelMapper;

public enum ParkingService {
    INSTANCE;

    private ParkingDAO parkingDAO;
    private ModelMapper modelMapper;

    ParkingService() {
        parkingDAO = new ParkingDAO();
        modelMapper = new ModelMapper();
    }
}
